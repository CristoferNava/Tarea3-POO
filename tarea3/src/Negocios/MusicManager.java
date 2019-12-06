package Negocios;

import Datos.DataArchivo;

import java.util.LinkedList;

public class MusicManager {
    private LinkedList<Music> musicList = new LinkedList<>();
    private DataArchivo datos;

    public MusicManager() throws Exception {
        try {
            this.datos = DataArchivo.getInstancia();
            this.datos.cargar();
            if (this.datos.get("music") != null) {
                this.musicList = (LinkedList<Music>) this.datos.get("music");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void add(Music music) throws Exception {
        int position = this.search(music);

        if (position == -1) {
            try {
                this.musicList.add(music);
                this.datos.add("music", this.musicList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("Ya existe el álbum");
        }
    }

    public void edit(Music music) throws Exception {
        int position = this.search(music);

        if (position != -1) {
            try {
                this.musicList.set(position, music);
                this.datos.add("music", this.musicList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("No se encontró el álbum");
        }
    }

    public void remove(Music music) throws Exception {
        int position = this.search(music);

        if (position != -1) {
            try {
                this.musicList.remove(position);
                this.datos.add("music", this.musicList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("No se encontró el álbum");
        }
    }

    public int search(Music music) {
        for (int i = 0; i <= this.musicList.size() - 1; i++) {
            if (this.musicList.get(i).getSKU().equals(music.getSKU())) {
                return i;
            }
        }
        return -1; // No se encontró el disco.
    }

    public LinkedList<Music> getMusicList() {
        return this.musicList;
    }
}
