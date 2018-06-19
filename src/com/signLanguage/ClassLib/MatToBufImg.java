/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signLanguage.ClassLib;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;


public class MatToBufImg {

    Mat matrix;
    MatOfByte mob;
    String fileExten;

    /**
     * The file extension string should be ".jpg", ".png", etc
     *
     * @param amatrix
     * @param fileExtension
     */
    public MatToBufImg(Mat amatrix, String fileExtension) {
        matrix = amatrix;
        fileExten = fileExtension;
        mob = new MatOfByte();
    }

    public MatToBufImg() {

    }

    /**
     * convert the matrix into a matrix of bytes appropriate for this file
     * extension
     *
     * @return
     */
    public BufferedImage getImage() {
        Highgui.imencode(fileExten, matrix, mob);
        //convert the "matrix of bytes" into a byte array
        byte[] byteArray = mob.toArray();
        BufferedImage bufImage = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (IOException e) {
        }
        return bufImage;
    }
}
