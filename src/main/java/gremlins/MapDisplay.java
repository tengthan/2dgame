package gremlins;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import processing.core.PImage;
import java.util.ArrayList;

public class MapDisplay{

    String mapPrint[][];

    char xCapital ='X';
    char b ='B';

    public MapDisplay(App app){
        mapPrint= new String[33][36];
        loadMap();
    }

    public void loadMap(){
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("level1.txt"));
            int col = 0;
			String line = reader.readLine();
			while (line != null) {
                for (int row = 0; row<line.length(); row++){
                    if(line.charAt(row)== xCapital){ 
                      mapPrint[col][row] = "X";
                    }
                    else if (line.charAt(row) == b){
                        mapPrint[col][row] = "B";
                    }
                    else{
                        mapPrint[col][row] = "S";
                    }
                }
                col+=1;
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void draw (App app,PImage brickwall,PImage stonewall){
        for(int i=0; i<mapPrint.length; i++) {
            for(int j=0; j<mapPrint[i].length; j++) {
                if(mapPrint[i][j]== "X"){ 
                    app.image(stonewall, j*20 , i*20);
                }
                else if (mapPrint[i][j]== "B"){
                    app.image(brickwall,  j*20 , i*20);
                }
            }
        }
    }
    public Integer[] germlinsPosition(){
        ArrayList<Integer> position = new ArrayList<Integer>();
        for(int i=0; i<mapPrint.length; i++) {
            for(int j=0; j<mapPrint[i].length; j++){
                if(mapPrint[i][j]== "W"){
                    position.add(i);
                    position.add(j);
                }
            }
        }Integer[] cordinate = (Integer[]) position.toArray();
        return cordinate;
    }
}