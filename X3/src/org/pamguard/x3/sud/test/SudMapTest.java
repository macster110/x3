package org.pamguard.x3.sud.test;

import java.io.File;
import java.io.IOException;

import org.pamguard.x3.sud.SudAudioInputStream;
import org.pamguard.x3.sud.SudFileExpander;
import org.pamguard.x3.sud.SudFileMap;
import org.pamguard.x3.sud.SudParams;

/**
 * Test loading a sudx map file. 
 */
public class SudMapTest {
	
	
	public static void main(String[] args) {
		
//		String file = "/Volumes/SMRU_PAM/2018_28_Gill_nets/4chan/20240628_AK660 H2/5434/5434.240628130225.sud";
		String file = "/Volumes/SMRU_PAM/2018_28_Gill_nets/4chan/20240628_AK660 H2/5434/5434.240628130225.sud";

		File sudFile = new File(file); 
		
		SudFileExpander sudFileExpander = new SudFileExpander(sudFile, new SudParams());
		
		try {

		SudFileMap sudFileMap1 = SudAudioInputStream.mapSudFile(sudFileExpander, null, true);
		SudAudioInputStream.saveSudMap(sudFileMap1, new File(file + "x2"));
		SudFileMap sudFileMap1A = SudAudioInputStream.loadSudMap(new File(file + "x2"));

		System.out.println("Total samples 1: "  + sudFileMap1.totalSamples + " " + sudFileMap1A.totalSamples);

//		String file= "/Volumes/SMRU_PAM/2018_28_Gill_nets/4chan/20240628_AK660 H2/5434/5434.240629224734.sudx";
//		String file = "/Volumes/SMRU_PAM/2018_28_Gill_nets/4chan/20240628_AK660 H2/5434/5434.240628130225.sud";
		
			SudFileMap sudFileMap2 = SudAudioInputStream.loadSudMap(new File(file + "x"));
			
			System.out.println("---Opened sud file map----");
			System.out.println("Total samples 2: "  + sudFileMap2.totalSamples);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
