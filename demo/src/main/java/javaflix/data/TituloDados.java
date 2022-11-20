package javaflix.data;

import java.io.*;
import java.util.*;

import javaflix.modelo.*;

public class TituloDados{
    private ArrayList<Titulo> tituloWrite = new ArrayList<>();
    private ArrayList<Titulo> tituloRead = new ArrayList<>();

    public ArrayList<Titulo> getTituloRead() {
        return tituloRead;
    }
    public ArrayList<Titulo> getTitulo() {
        return tituloWrite;
    }

    private final void readObject(ObjectInputStream aInputStream)throws ClassNotFoundException, IOException{
        aInputStream.defaultReadObject();
    }

    public boolean cadastrarFilme(Filme f) {
        boolean aux;
        try {
            FileOutputStream fluxo = new FileOutputStream("TitulosDB.ser", true);
            ObjectOutputStream obs = new ObjectOutputStream(fluxo);
            tituloWrite.add(f);
            obs.writeObject(f);
            obs.close();
            aux = true;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            aux = false;
        } catch (IOException x) {
            System.out.println(x.getMessage());
            aux = false;
        }catch (NullPointerException r) {
            System.out.println(r.getMessage());
            aux = false;
        }
        return aux;
    }

    public boolean cadastrarSerie(Serie s) {
        boolean aux;
        try {
            FileOutputStream fluxo = new FileOutputStream("TitulosDB.ser", true);
            ObjectOutputStream obs = new ObjectOutputStream(fluxo);
            tituloWrite.add(s);
            obs.writeObject(s);
            obs.close();
            aux = true;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            aux = false;
        } catch (IOException x) {
            System.out.println(x.getMessage());
            aux = false;
        }catch (NullPointerException r) {
            System.out.println(r.getMessage());
            aux = false;
        }
        return aux;
    }

    public boolean cadastrarDocumentario(Documentario doc) {
        boolean aux;
        try {
            FileOutputStream fluxo = new FileOutputStream("TitulosDB.ser", true);
            ObjectOutputStream obs = new ObjectOutputStream(fluxo);
            tituloWrite.add(doc);
            obs.writeObject(doc);
            obs.close();
            aux = true;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            aux = false;
        } catch (IOException x) {
            System.out.println(x.getMessage());
            aux = false;
        }catch (NullPointerException r) {
            System.out.println(r.getMessage());
            aux = false;
        }
        return aux;
    }

    public ArrayList<Titulo> listarTitulo() {
        int index = tituloWrite.size();
        int contador = 0;
        int aux = index - contador - 1;
        int auxS = aux;
        int auxD = auxS;
        try {
            FileInputStream fluxo = new FileInputStream("TitulosDB.ser");
            ObjectInputStream obs = null;
            ObjectInputStream obsSerie = null;
            ObjectInputStream obsDoc = null;
            while (fluxo.available() > 0) {
                if(tituloWrite.get(aux).getLancamento() == "filme"){
                    obs = new ObjectInputStream(fluxo);
                    Filme f = (Filme) obs.readObject();
                    tituloRead.add(f);
                    for (int i = 0; i < tituloRead.size(); i++) {
                        if (i > 0) {
                            if (tituloRead.get(i) == tituloRead.get(i - 1))
                                tituloRead.remove(tituloRead.get(i));
                        }
                    }
                    contador++;
                    aux = index - contador - 1;
                }
                if(tituloWrite.get(auxS).getLancamento() == "serie"){
                    obsSerie = new ObjectInputStream(fluxo);
                    Serie s = (Serie) obsSerie.readObject();
                    tituloRead.add(s);
                    for (int i = 0; i < tituloRead.size(); i++) {
                        if (i > 0) {
                            if (tituloRead.get(i) == tituloRead.get(i - 1))
                                tituloRead.remove(tituloRead.get(i));
                        }
                    }
                    contador++;
                    auxS = index - contador - 1;
                }
                if(tituloWrite.get(auxD).getLancamento() == "documentario"){
                    obsDoc = new ObjectInputStream(fluxo);
                    Documentario doc= (Documentario) obsDoc.readObject();
                    tituloRead.add(doc);
                    for (int i = 0; i < tituloRead.size(); i++) {
                        if (i > 0) {
                            if (tituloRead.get(i) == tituloRead.get(i - 1))
                                tituloRead.remove(tituloRead.get(i));
                        }
                    }
                    contador++;
                    auxD = index - contador - 1;
                }
            }
            obs.close();
            obsDoc.close();
            obsSerie.close();
        } catch (ClassNotFoundException i) {
            System.out.println(i.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }
        return tituloRead;
    }
}
