package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.service.QRCodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class QRServiceImpl implements QRCodeService {
    @Override
    public byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrWriter = new QRCodeWriter();

        BitMatrix matrix = qrWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix,"PNG", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
