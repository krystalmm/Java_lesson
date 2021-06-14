package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Chapter15_2 {
	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault();
//		PathクラスのインスタンスをFileSystem.getPathメソッドで生成
		Path inputPath = fs.getPath("resources/input.txt");
		Path outputPath = fs.getPath("resources/output.txt");
		
//		try-with-resources文（tryの後に初期化の処理を書く！）
		try (BufferedReader reader = Files.newBufferedReader(inputPath);
				BufferedWriter writer = Files.newBufferedWriter(outputPath);) {
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
//				文字数が5以外の場合はスキップ
				if (line.length() != 5) {
					continue;
				}
				
//				読み込んだ1行を出力
				writer.write(line);
//				改行がついていないので改行を出力
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("出力処理終了");
		}
	}
}
