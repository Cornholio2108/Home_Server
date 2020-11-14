package com.home_server.media;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NetworkFileHandler {
	public List<NASFile> loadFiles(String folders) {
		List<NASFile> fileList = new ArrayList();
//		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("\\\\SYNOSTATION\\photo\\"+folders))) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/media/NAS/photo/"+folders))) {
			for (Path path : stream) {
//				if (!Files.isDirectory(path)) {
//					fileList.add(path.getFileName().toString());
//				}
				NASFile nasFile = new NASFile();
				nasFile.setFileName(path.getFileName().toString());
				nasFile.setPath(path.toString());
				nasFile.setFolder(Files.isDirectory(path));
				fileList.add(nasFile);
			}
			return fileList;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
