package zzztwita;

/**
 *
 * @author andre
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Usuario_Twitter {
     /*
    Cambios en esta clase: 
    Orden del formato: usuario - genero - nombre completo - contra - fecha - edad - boolean activo - direccion img
    
    */
   
    private String user;
    private char genero;
    private String nombre;
    private String contra;
    private Date fecha_Creacion;
    private int edad;
    private boolean activo;
    private String img_path;
    
    private RandomAccessFile file_Users;
    private RandomAccessFile file_Followers;
    private RandomAccessFile file_Following;
    private RandomAccessFile file_Twits;
    
    
    public Usuario_Twitter(String user) throws IOException,ExcepcionPropia,FileNotFoundException{
        
        file_Users = new RandomAccessFile("BDTWITEH/usuarios.twc", "rw");
        
        if(usuarioExiste(user, file_Users)){
            System.out.println("1");
            this.user = user;
            this.genero = file_Users.readChar();
            this.nombre = file_Users.readUTF();
            this.contra = file_Users.readUTF();
            this.fecha_Creacion = new Date(file_Users.readLong());
            this.edad = file_Users.readInt();
            this.activo = file_Users.readBoolean();
            this.img_path = file_Users.readUTF();
            
            file_Followers = new RandomAccessFile("BDTWITEH/" + user+"/followers.twc", "rw");
            file_Following = new RandomAccessFile("BDTWITEH/" + user+"/followings.twc", "rw");
            file_Twits = new RandomAccessFile("BDTWITEH/" + user+"/twits.twc", "rw");

        }else{
            throw new ExcepcionPropia();
        }
        
        
    }
    
    public String getUser() {
        return user;
    }

    public String getContra() {
        return contra;
    }

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public Date getCreacion() {
        return fecha_Creacion;
    }

    public boolean isActivo() {
        return activo;
    }
    

    public String getImg_path() {
        return img_path;
    }
    

    

    public RandomAccessFile getF_usuarios() {
        return file_Users;
    }

    public int cantTwits()throws IOException{
        ArrayList<String[]> mensajes = new ArrayList<>();
        int contador=0;
        file_Twits.seek(0);
        while (file_Twits.getFilePointer() < file_Twits.length()) {
            String[] temp = new String[3];
            temp[0] = file_Twits.readUTF();
            temp[1] = file_Twits.readUTF();
            temp[2] = file_Twits.readLong() + "";
            mensajes.add(temp);
            contador++;
        }
        return contador;
    }
    public ArrayList<String[]> misTwits() throws IOException {
        ArrayList<String[]> mensajes = new ArrayList<>();

        file_Twits.seek(0);
        while (file_Twits.getFilePointer() < file_Twits.length()) {
            String[] temp = new String[3];
            temp[0] = file_Twits.readUTF();
            temp[1] = file_Twits.readUTF();
            temp[2] = file_Twits.readLong() + "";
            mensajes.add(temp);
        }

        return mensajes;

    }

    public static boolean usuarioExiste(String user, RandomAccessFile usuarios) throws IOException {
        usuarios.seek(0);
        while (usuarios.getFilePointer()<usuarios.length()){
            String username = usuarios.readUTF();
            if (username.equals(user)) {
                return true;
            } else {
                usuarios.readChar();
                usuarios.readUTF();
                usuarios.readUTF();
                usuarios.readLong();
                usuarios.readInt();
                usuarios.readBoolean();
                usuarios.readUTF();
                
                if (usuarios.getFilePointer() == usuarios.length()) {
                    return false;
                }
            }

        }
        return false;
    }

    public ArrayList<String[]> cargarTwits() throws IOException, ExcepcionPropia {
        ArrayList<String[]> twits = new ArrayList<>();
        
        //Cargar mis twits.
        if (misTwits() != null) {
            twits.addAll(misTwits());
        }

        file_Following.seek(0);

        while (file_Following.getFilePointer() < file_Following.length()) {
            Usuario_Twitter temp = new Usuario_Twitter(file_Following.readUTF());   
            boolean meSigue=file_Following.readBoolean();
            if (temp.activo && meSigue){
                twits.addAll(temp.misTwits());
            }
        }
       //Twits cargados de las personas que sigo si esta activo. 
       

        //ordenar mis twist del mas antiguo al mas reciente
        for (int i = 0; i < twits.size(); i++) {
            for (int j = 0; j < twits.size() - i - 1; j++) {
                if (Long.parseLong(twits.get(i)[2]) > Long.parseLong(twits.get(i + 1)[2])) {
                    String[] temporal = twits.get(i + 1);
                    twits.set(i + 1, twits.get(i));
                    twits.set(i, temporal);
                }
            }
        }
       //Twits cargados y ordenados.
        return twits;
    }
    

    public void guardarTwit(String msg) throws IOException {
        file_Twits.seek(file_Twits.length());
        file_Twits.writeUTF(this.user);
        file_Twits.writeUTF(msg);
        file_Twits.writeLong(Calendar.getInstance().getTimeInMillis());
    }

    public ArrayList<String[]> cargarInteracciones() throws IOException, ExcepcionPropia {
        //Carga todos los twits;
        ArrayList<String[]> twits = new ArrayList<>();
        file_Users.seek(0);

        while (file_Users.getFilePointer() < file_Users.length()) {
            Usuario_Twitter temp = new Usuario_Twitter(file_Users.readUTF());
            if (temp.isActivo()) {
                twits.addAll(temp.misTwits());
            }
            sigUsuario();
        }

        //Agrega los elementos donde se menciona al usuario;
        ArrayList<String[]> interacciones = new ArrayList<>();

        String user = "@" + this.user;

        for (int i = 0; i < twits.size(); i++) {
            String[] temp = twits.get(i);
            String msg = temp[1];

            if (msg.contains(user)) {
                interacciones.add(twits.get(i));
            }
        }

        //ordenar los twist del mas antiguo al mas reciente
        for (int i = 0; i < interacciones.size(); i++) {
            for (int j = 0; j < interacciones.size() - i - 1; j++) {
                if (Long.parseLong(interacciones.get(i)[2]) > Long.parseLong(interacciones.get(i + 1)[2])) {
                    String[] temp = interacciones.get(i + 1);
                    interacciones.set(i + 1, interacciones.get(i));
                    interacciones.set(i, temp);
                }
            }
        }
        return interacciones;
    }

    public ArrayList<String[]> buscarHashTag(String[] str) throws IOException, FileNotFoundException, ExcepcionPropia {
        ArrayList<String[]> twits = new ArrayList<>();
        file_Users.seek(0);

        while (file_Users.getFilePointer() < file_Users.length()) {
            Usuario_Twitter temp = new Usuario_Twitter(file_Users.readUTF());
            if (temp.activo) {
                twits.addAll(temp.misTwits());
            }
            sigUsuario();
        }

        //ordenar los twist del mas antiguo al mas reciente
        for (int i = 0; i < twits.size(); i++) {
            for (int j = 0; j < twits.size() - i - 1; j++) {
                if (Long.parseLong(twits.get(i)[2]) > Long.parseLong(twits.get(i + 1)[2])) {
                    String[] temp = twits.get(i + 1);
                    twits.set(i + 1, twits.get(i));
                    twits.set(i, temp);
                }
            }
        }

        ArrayList<String[]> twits_hash = new ArrayList<>();

        String[] hashtags = str;

        for (int i = 0; i < twits.size(); i++) {
            String[] temp = twits.get(i);
            String msg = temp[1];

            //busca los hashtag en el msg 
            ArrayList<String> hash_msg = new ArrayList<>();
            for (int j = 0; j < msg.length(); j++) {
                if (msg.charAt(j) == '#') {
                    for (int k = j + 1; k < msg.length(); k++) {
                        if (msg.charAt(k) == ' ' || k == msg.length() - 1) {
                            String sub;
                            if (k == msg.length() - 1) {
                                sub = msg.substring(j, k + 1);
                                hash_msg.add(sub);
                            } else {
                                sub = msg.substring(j, k);
                                hash_msg.add(sub);
                                break;
                            }
                        }
                    }
                }
            }

            //Si algun hashtag que se encontro en el msg esta en los hashtag 
            // que le mandamos lo agrega
            for (int j = 0; j < hashtags.length; j++) {
                if (hash_msg.contains(hashtags[j])) {
                    if (!twits_hash.contains(temp)) {
                        twits_hash.add(temp);
                        break;
                    }
                }
            }
        }
        return twits_hash;
    }

    //activar y descativar
    public void descUsuario() throws IOException {
        if (usuarioExiste(this.user, file_Users)) {
            file_Users.readChar();
            file_Users.readUTF();
            file_Users.readUTF();
            file_Users.readLong();
            file_Users.readInt();
            file_Users.writeBoolean(false);
            file_Users.readUTF();
        }
    }

    public void actUsuario() throws IOException {
        if (usuarioExiste(this.user, file_Users)) {
            file_Users.readChar();
            file_Users.readUTF();
            file_Users.readUTF();
            file_Users.readLong();
            file_Users.readInt();
            file_Users.writeBoolean(true);
            file_Users.readUTF();
        }
    }

    
    //Funciones para seguir/ desactivar 
    
    public int getFollowings() throws IOException {
            int contador = 0;
            file_Following.seek(0);

            while (file_Following.getFilePointer() < file_Following.length()) {
                file_Following.readUTF();
                if(file_Following.readBoolean()){
                    contador++;
                }
            }
            return contador;
    }

    public int getFollowers() throws IOException {
        int contador=0;
        file_Followers.seek(0);
        
        while (file_Followers.getFilePointer() < file_Followers.length()) {
            file_Followers.readUTF();
            if(file_Followers.readBoolean()){
                contador++;
            }
        }
        return contador;  
    }
    
    public boolean loSigo(String usr) throws IOException{
            boolean sigo = false;
            file_Following.seek(0);

            while (file_Following.getFilePointer() < file_Following.length()) {
                String tmpUsr = file_Following.readUTF();
                long posc = file_Following.getFilePointer();
                boolean tmpAct = file_Following.readBoolean();
                
                if(tmpUsr.equals(usr)){
                    file_Following.seek(posc);
                    sigo = tmpAct;
                    break;
                }
            }
            return sigo;
    }
    
   public void dejarDeSeguir(String usuario) throws IOException, ExcepcionPropia{
        Usuario_Twitter selectUsr = new Usuario_Twitter(usuario);
        RandomAccessFile userFollowers =selectUsr.file_Followers;
            file_Following.seek(0);

            //Recorre el raf del loggeado
            while (file_Following.getFilePointer() < file_Following.length()) { 
                //Lee el usuario loggeado
                String user = file_Following.readUTF();
                //validacion para saber si es el user loggeado
                if(user.equals(usuario)){
                    file_Following.writeBoolean(false);
                    JOptionPane.showMessageDialog(null, "Se ha dejado de seguir!");
                    userFollowers.seek(0);
                    
                    //Recorre el raf del otro usuario
                    while(userFollowers.getFilePointer()<userFollowers.length()){
                        //validacion para detectar al usuario loggeado y escribir el boolean false para que saber que ya no me sigue
                        if(userFollowers.readUTF().equals(this.user)){
                            userFollowers.writeBoolean(false);
                            System.out.println("Se le resto 1 a mis followings");
                            break;
                        }
                        
                        userFollowers.readBoolean();
                    }
                    break;
                }
                file_Following.readBoolean();
            }
        
    }
    
    public void seguirAndAddFollow(String persona) throws IOException, ExcepcionPropia{
        RandomAccessFile userFile = new RandomAccessFile("BDTWITEH/"+persona+"/followers.twc","rw");
        boolean yaSigue=false;
        userFile.seek(0);
        
        //Recorre el archivo del usuario a seguir
        while(userFile.getFilePointer()<userFile.length()){
            //Lee nombre
            String user = userFile.readUTF();
            long puntero = userFile.getFilePointer();
            boolean seguido = userFile.readBoolean();
            //Condicional para saber si lo sigo o no
            if(user.equals(this.user) && seguido){
                JOptionPane.showMessageDialog(null, "Ya haz seguido a este usuario!");
                yaSigue=true;
            }else if(user.equals(this.user) && !seguido){
                //Se actualiza y lo sigue de nuevo
                userFile.seek(puntero);
                userFile.writeBoolean(true);
                yaSigue=true;
                file_Following.seek(0);
                while(file_Following.getFilePointer()<file_Following.length()){
                    String userz = file_Following.readUTF();
                    long punteroz = file_Following.getFilePointer();
                    file_Following.readBoolean();
                    if(userz.equals(persona)){
                        file_Following.seek(punteroz);
                        file_Following.writeBoolean(true);
                    }       
                }
                JOptionPane.showMessageDialog(null, "Se ha seguido al usuario!");
            }
                
        }
        
        if(!yaSigue){
            userFile.writeUTF(this.user);
            userFile.writeBoolean(true);
            file_Following.writeUTF(persona);
            file_Following.writeBoolean(true);
            JOptionPane.showMessageDialog(null, "Se ha seguido al usuario!");
        }
    }
 
//    
//    public void desSeguidor(String usr) throws IOException{
//         if(file_Followers.length() > 0){
//            
//            file_Followers.seek(0);
//
//            while (file_Followers.getFilePointer() < file_Followers.length()) {
//                String tmpUsr = file_Followers.readUTF();
//                
//                if((tmpUsr.equals(usr))){
//                    file_Followers.writeBoolean(false);
//                    return;
//                }
//            }
//        }
//    }
    
    private void sigUsuario() throws IOException {
        file_Users.readChar();
        file_Users.readUTF();
        file_Users.readUTF();
        file_Users.readLong();
        file_Users.readInt();
        file_Users.readBoolean();
        file_Users.readUTF();
    }
}
