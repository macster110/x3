
package org.pamguard.x3.sud.test;

import java.io.File;
import java.io.IOException;

import org.pamguard.x3.sud.Chunk;
import org.pamguard.x3.sud.SudFileExpander;
import org.pamguard.x3.sud.SudParams;

/**
 * Basic test for opening a .sud file
 * @author Jamie Macaulay
 *
 */
public class SudarFileTest {
	
	
	public static void main(String[] args) {
		System.out.println("Hello .sud file decompression");
				
		long time0 = System.currentTimeMillis();

		
//		String filePath = "/Users/au671271/MATLAB-Drive/MATLAB/PAMGUARD/sud/335564854.180411000003.sud";
//		String filePath = "/Users/au671271/Library/CloudStorage/GoogleDrive-macster110@gmail.com/My Drive/PAMGuard_dev/sud_decompression/singlechan_exmple/67411977.171215195605.sud";
//		String filePath = "/Volumes/PicoSD/PICO_20230013_142946_878.sud";
		
//		String filePath = "/Users/au671271/Library/Mobile Documents/com~apple~CloudDocs/Dev/X3/X3/test_sud.sud";
		
		
//		String filePath = "/Volumes/JamieBack_1/x3/sud_dataset_1chan_clks/7140.221020160451.sud";
		String filePath = "D:\\x3\\sudexample_3chan\\738742278.180708083005.sud";

		SudParams sudParams = new SudParams();
		sudParams.setVerbose(false);
		sudParams.setFileSave(false, true, true, false);
		sudParams.setSudEnable(true, true, true);


		SudFileExpander sudFileExpander = new SudFileExpander(new File(filePath), sudParams); 
		
//		sudFileExpander.addSudFileListener((chunkID, sudChunk)->{
//			
//
//			System.out.println(sudFileExpander.getChunkFileType(chunkID));
//			System.out.println(sudChunk.chunkHeader.toHeaderString()); 
//
//			if (sudFileExpander.getChunkFileType(chunkID).equals("X3V2")) {
//				System.out.print(sudFileExpander.getChunkFileType(chunkID) +" x3 DATA:");
//				sudChunk.chunkHeader.toHeaderString(); 
//				
//				System.out.println("X3 nBytes: " + sudChunk.buffer.length);
//				System.out.println(chunkData2String(sudChunk));
//			}
//			
//			if (sudFileExpander.getChunkFileType(chunkID).equals("wav")) {
//				System.out.print(sudFileExpander.getChunkFileType(chunkID) +" WAV DATA:");
//				sudChunk.chunkHeader.toHeaderString(); 
//								
//				System.out.println("WAV nBytes: " + sudChunk.buffer.length);
//				System.out.println(chunkData2String(sudChunk));
//			}
//		});
//		
		try {
			sudFileExpander.processFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long time1 = System.currentTimeMillis();

		System.out.println("Processing time: " +  (time1-time0));

	}
	
	public static String chunkData2String(Chunk sudChunk) {
		String arr = ""; 
//		for (int i=0; i<sudChunk.buffer.length; i++) {
//			arr += (sudChunk.buffer[i] + ","); 
//		}
		for (int i=0; i<Math.min(sudChunk.buffer.length, 50); i++) {
			arr += (sudChunk.buffer[i] + ","); 
		}
		return arr; 
	}

}
