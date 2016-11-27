/* 
 * Copyright (C) 2014 Vladislav Mladenov<vladislav.mladenov@rub.de>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package org.rub.nds.sso.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Vladislav Mladenov<vladislav.mladenov@rub.de>
 */
public class FileUtils {
    private static Logger _log = LoggerFactory.getLogger(FileUtils.class);

    /**
     *
     * @param dirPath
     * @param sufixFiles
     * @return
     * @throws IOException
     */
    public static List<String> readFilesFromDir(final String dirPath, final String sufixFiles) throws IOException {
        _log.debug("Reading directory: " + dirPath + " with files having the following suffix: " + sufixFiles);

        List<String> files = new ArrayList<>();

        try {
            File folder = new File(dirPath);

            FilenameFilter filter = createFilenameFilter(sufixFiles);

            for (final File fileEntry : folder.listFiles(filter)) {
                _log.debug("File + " + fileEntry.getName() + " found and added!");
                files.add(readFile(fileEntry.getAbsolutePath()));
            }
        } catch (NullPointerException ex) {
            throw new IOException("Cannot fetch the information! NullpointerException", ex);
        }

        return files;
    }

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readFile(final String filePath) throws IOException {
        return readFile(filePath, Charset.defaultCharset());
    }

    /**
     *
     * @param filePath
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String readFile(final String filePath, final Charset encoding) throws IOException {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            return encoding.decode(ByteBuffer.wrap(encoded)).toString();
        } catch (NullPointerException ex) {
            throw new IOException("Cannot read File:" + filePath + "! NullPointerException!", ex);

        }
    }

    /**
     *
     * @param suffix
     * @return
     * @throws IOException
     */
    public static FilenameFilter createFilenameFilter(final String suffix) throws IOException {
        FilenameFilter filter;

        try {
            filter = new FilenameFilter() {
                @Override
                public boolean accept(File directory, String fileName) {
                    return fileName.endsWith(suffix);
                }
            };
        } catch (NullPointerException ex) {
            throw new IOException("Cannot create FilenameFilter! NullPointerException!", ex);
        }

        return filter;
    }
}
