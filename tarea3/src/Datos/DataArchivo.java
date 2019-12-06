package Datos;

import java.io.*;
import java.util.TreeMap;

public class DataArchivo {
    private static DataArchivo DATOS = null;
    private TreeMap<String, Object> valores = new TreeMap<>();
    private final String archivo = "data.dat";

    private DataArchivo() {}

    public static DataArchivo getInstancia() {
        if (DATOS == null) {
            DATOS = new DataArchivo();
        }
        return DATOS;
    }

    public void add(String key, Object value) {
        valores.put(key, value);
    }

    public void edit(String key, Object value) {
        if (this.valores.containsKey(key)) {
            this.valores.replace(key, value);
        } else {
            this.valores.put(key, value);
        }
    }

    public Object get(String key) {
        if (this.valores.containsKey(key)) {
            return this.valores.get(key);
        }
        return null;
    }

    public void cargar() throws Exception {
        try {
            if (!new File(archivo).exists()) {
                return;
            }
            ObjectInputStream oisCargar = new ObjectInputStream(new FileInputStream(archivo));
            this.valores = (TreeMap<String, Object>) oisCargar.readObject();
            oisCargar.close();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void guardar() throws Exception {
        try {
            ObjectOutputStream oosGuardar = new ObjectOutputStream(new FileOutputStream(archivo));
            oosGuardar.writeObject(this.valores);
            oosGuardar.close();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}