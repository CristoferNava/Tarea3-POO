package Negocios;

import Datos.DataArchivo;

import java.util.LinkedList;

public class VideogameManager {
    private LinkedList<Videogame> videogamesList = new LinkedList<>();
    private DataArchivo datos;

    public VideogameManager() throws Exception {
        try {
            this.datos = DataArchivo.getInstancia();
            this.datos.cargar();
            if (this.datos.get("videogame") != null) {
                this.videogamesList = (LinkedList<Videogame>) this.datos.get("videogame");
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void add(Videogame videogame) throws Exception {
        int position = this.search(videogame);

        if (position == -1) {
            try {
                this.videogamesList.add(videogame);
                this.datos.add("videogame", this.videogamesList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("Ya existe el videojuego");
        }
    }

    public void edit(Videogame videogame) throws Exception {
        int position = this.search(videogame);

        if (position != -1) {
            try {
                this.videogamesList.set(position, videogame);
                this.datos.add("videogame", this.videogamesList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("No se encontró el videojuego");
        }
    }

    public void remove(Videogame videogame) throws Exception {
        int position = this.search(videogame);

        if (position != -1) {
            try {
                this.videogamesList.remove(position);
                this.datos.add("videogame", this.videogamesList);
                this.datos.guardar();
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        } else {
            System.out.println("No se encontró el videojuego");
        }
    }

    public int search(Videogame videogame) {
        for (int i = 0; i <= this.videogamesList.size() - 1; i++) {
            if (this.videogamesList.get(i).getSKU().equals(videogame.getSKU())) {
                return i;
            }
        }
        return -1; // No se encontró el videojuego.
    }

    public LinkedList<Videogame> getVideogamesList() {
        return this.videogamesList;
    }
}
