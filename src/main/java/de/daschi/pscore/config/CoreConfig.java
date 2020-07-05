package de.daschi.pscore.config;

import de.daschi.pscore.PSCore;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.IOException;

public class CoreConfig {
    public static void initialise() throws IOException {
        final YamlFile yamlFile = new YamlFile(new File("PSCore/" + PSCore.getVersion() + "/config.yml"));
        if (!yamlFile.exists()) {
            yamlFile.createNewFile(true);

            final File configFolder = new File("PSCore");
            for (final File file : configFolder.listFiles()) {
                System.out.println(file);
            }
        }
    }
}
