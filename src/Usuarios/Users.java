package Usuarios;

import Menu.excepcionUsuario;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Users {

    RandomAccessFile User;
    static File archivos = null;

    public Users() {
        try {
            User = new RandomAccessFile("ArchivoUsuario/RegistrosUsers.usr", "rw");
        } catch (IOException e) {

        }

    }

    public long ObtenerPuntero() throws IOException {

        if (User.length() != 0) {
            User.seek(0);
            while (User.getFilePointer() < User.length()) {
                User.readUTF();
                User.readUTF();
                User.readUTF();
            }
        }
        return User.getFilePointer();

    }

    public void setArchivos(String direccion) {
        archivos = new File(direccion);
    }

    public boolean crearFolder() {
        return archivos.mkdir();
    }

    public boolean CrearCarpetasUser(String usuario, String contraseña, String tipo) throws excepcionUsuario {
        try {
            User.seek(User.length());
            User.writeUTF(usuario);
            User.writeUTF(contraseña);
            User.writeUTF(tipo);

            setArchivos("Z");
            archivos.mkdir();
            setArchivos("Z/" + usuario);

            if (crearFolder()) {
                setArchivos("Z/" + usuario + "/Mis Imagenes");
                archivos.mkdir();
                
                setArchivos("Z/" + usuario + "/Mis Documentos");
                archivos.mkdir();

                setArchivos("Z/" + usuario + "/Mi Musica");
                archivos.mkdir();
                return true;
            }
         } catch (IOException e) {
            throw new excepcionUsuario("Error al crear carpetas para el usuario " + usuario);
        }
        return false;
    }
    
    
    public boolean VerificarUsuarios(String usuario, String contraseña) throws excepcionUsuario {
        try {
            User.seek(0);
            String user;
            String password;
            while (User.getFilePointer() < User.length()) {
                long pos = User.getFilePointer();
                user = User.readUTF();
                password = User.readUTF();
                User.readUTF();
                if (user.equals(usuario) && password.equals(contraseña)) {
                    User.seek(pos);
                    return true;
                }
            }
        } catch (IOException e) {
            throw new excepcionUsuario("Error al verificar usuario " + usuario);
        }
        return false;
    }
        public boolean buscarUsuario(String usuario)throws excepcionUsuario {
        try {
            User.seek(0);
            String user;
            while (User.getFilePointer() < User.length()) {
                long pos = User.getFilePointer();
                user = User.readUTF();
                User.readUTF();
                User.readUTF();
                if (user.equals(usuario)) {
                    User.seek(pos);
                    return true;
                }
            }
        } catch (IOException e) {
            throw new excepcionUsuario("Error al buscar usuario " + usuario);
        }
        return false;
    }

    public String BuscarTipo(String usuario, String contra) throws excepcionUsuario {

        try {
            User.seek(0);
            String user;
            String password;
            String tipo;
            while (User.getFilePointer() < User.length()) {
                user = User.readUTF();
                password = User.readUTF();
                tipo = User.readUTF();
                if (user.equals(usuario) && password.equals(contra)) {
                    return tipo;
                }
            }
           
        } catch (IOException e) {
            throw new excepcionUsuario("Error al buscar tipo de usuario " + usuario);
        }
        return null;
    }

    

}
