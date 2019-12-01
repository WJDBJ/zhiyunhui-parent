package com.controller;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @author XJ
 */
public class TextPoi {
    public static String getContext(String path) {
        String content = null;
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            InputStream is = null;
            HWPFDocument doc = null;
            XWPFDocument docx = null;
            POIXMLTextExtractor extractor = null;
            try {
                is = new FileInputStream(file);
                if (path.endsWith(".doc")) {
                    doc = new HWPFDocument(is);
                    // 文档文本内容
                    content = doc.getDocumentText();
                    // 文档图片内容
                    PicturesTable picturesTable = doc.getPicturesTable();
                    List<Picture> pictures = picturesTable.getAllPictures();
                    for (Picture picture : pictures) {
                        // 输出图片到磁盘
                        OutputStream out = new FileOutputStream(
                                new File("D:\\temp\\" + UUID.randomUUID() + "." + picture.suggestFileExtension()));
                        picture.writeImageContent(out);
                        out.close();
                    }
                } else if (path.endsWith("docx")) {
                    docx = new XWPFDocument(is);
                    extractor = new XWPFWordExtractor(docx);

                    // 文档文本内容
                    content = extractor.getText();
                    // 文档图片内容
                    List<XWPFPictureData> pictures = docx.getAllPictures();
                    for (XWPFPictureData picture : pictures) {
                        byte[] bytev = picture.getData();
                        // 输出图片到磁盘
                        FileOutputStream out = new FileOutputStream(
                                "D:\\temp\\temp\\" + UUID.randomUUID() + picture.getFileName());
                        out.write(bytev);
                        out.close();
                    }
                } else {
                    System.out.println("此文件不是word文件！");
                }
            } catch (Exception e) {
            } finally {
                try {
                    if (doc != null) {
                        doc.close();
                    }
                    if (extractor != null) {
                        extractor.close();
                    }
                    if (docx != null) {
                        docx.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                }
            }
        }
        return content;
    }
}
