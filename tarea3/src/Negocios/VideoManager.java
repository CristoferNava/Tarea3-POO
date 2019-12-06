package Negocios;

import Datos.DataArchivo;

import java.util.LinkedList;

public class VideoManager {
    private LinkedList<Video> videosList = new LinkedList<>();
    private DataArchivo datos;

    public VideoManager() throws Exception {
        try {
            this.datos = DataArchivo.getInstancia();
            this.datos.cargar();
            if (this.datos.get("video") != null) {
                this.videosList = (LinkedList<Video>) this.datos.get("video");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void add(Video video) throws Exception {
        int position = this.search(video);

        if (position == -1) {
            try {
                this.videosList.add(video);
                this.datos.add("video", this.videosList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("Ya existe el vídeo");
        }
    }

    public void edit(Video video) throws Exception {
        int position = this.search(video);

        if (position != -1) {
            try {
                this.videosList.set(position, video);
                this.datos.add("video", this.videosList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("No se encontró el vídeo");
        }
    }

    public void remove(Video video) throws Exception {
        int position = this.search(video);

        if (position != -1) {
            try {
                this.videosList.remove(position);
                this.datos.add("video", this.videosList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("No se encontró el vídeo");
        }
    }

    public int search(Video video) {
        for (int i = 0; i <= this.videosList.size() - 1; i++) {
            if (this.videosList.get(i).getSKU().equals(video.getSKU())) {
                return i;
            }
        }
        return -1; // No se encontró el vídeo.
    }

    public LinkedList<Video> getVideosList() {
        return this.videosList;
    }
}
