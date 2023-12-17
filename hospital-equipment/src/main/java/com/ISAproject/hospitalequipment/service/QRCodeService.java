package com.ISAproject.hospitalequipment.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodeService {



    public byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException;
}
