package com.home_server.media;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class NetworkFileHandler {
	static {
		Set<String> fileList = new HashSet<>();
		try (DirectoryStream<Path> stream = Files
				.newDirectoryStream(Paths.get("\\\\SYNOSTATION\\photo\\2018_03_Südafrika\\Südafrika\\"))) {
			for (Path path : stream) {
				if (!Files.isDirectory(path)) {
					fileList.add(path.getFileName().toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
