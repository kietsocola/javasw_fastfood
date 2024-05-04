package lam;


import javax.swing.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class PDFExporter extends JFrame {
    private JTextField textField;
    private JButton exportButton;

    public PDFExporter() {
        setTitle("PDF Exporter");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textField = new JTextField(20);
        exportButton = new JButton("Export to PDF");

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToPDF();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter text:"));
        panel.add(textField);
        panel.add(exportButton);
        add(panel, BorderLayout.CENTER);
    }

    public void exportToPDF() {
    	int[] maSP = {1,2,3,4,2,3,4,2,3,4,2,3,4,2,3,4};
    	String[] tenSP = {"co ca", "pep si" , "dui ga xao xa ot" , "banh mi", "pep si" , "dui ga xao xa ot" , "banh mi", "pep si" , "dui ga xao xa ot" , "banh mi", "pep si" , "dui ga xao xa ot" , "banh mi", "pep si" , "dui ga xao xa ot" , "banh mi"};
    	int[] soLuong = {1,2,3,4,2,3,4,2,3,4,2,3,4,2,3,4};
    	int[] donGia = {10000,20000,30000,40000,20000,30000,40000,20000,30000,40000,20000,30000,40000,20000,30000,40000};
        try {
        	PDDocument document = new PDDocument();
            PDPage[] page = new PDPage[100];
            int soPage = 0;
            float distanceRow = 30 ;
            float x1= 30 ;
            float x2 = 580;
            float y1 = 600 ;
            float y2 = 570;
            float indexRow = 580;
            int tongTien = 0;
            int indexMaSP = 0;
            for(;soPage < 100 ; soPage++)
            {
                page[soPage] = new PDPage();
                document.addPage(page[soPage]);
                if(soPage > 0) {
                	y1 = 700;
                	y2 = 670;
                    indexRow = 680;
                }
            	try (PDPageContentStream contentStream = new PDPageContentStream(document, page[soPage])) {
                    if(soPage == 0) {
                    	contentStream.beginText();
                        contentStream.setFont(PDType1Font.TIMES_BOLD, 16);
                        contentStream.newLineAtOffset(230, 700);
                        contentStream.showText("CHI TIET SAN PHAM");
                        contentStream.setFont(PDType1Font.TIMES_ROMAN, 14);
                        contentStream.newLineAtOffset(-130, -20);
                        contentStream.showText("Nhan vien : Tran Thi B");
                        contentStream.newLineAtOffset(0, -20);
                        contentStream.showText("Khach hang : Nguyen Van A");
                        contentStream.newLineAtOffset(0, -20);
                        contentStream.showText("Nha cung cap : Cong ty phan phoi san pham a au");
                        contentStream.newLineAtOffset(50, -20);
                        contentStream.showText("========================================");
                        contentStream.newLineAtOffset(-50, -20);
                        contentStream.endText();
                        //line ngang ben tren
                        contentStream.drawLine(30, 600, 580, 600); 
                        //line dung ben phai
                        contentStream.drawLine(30, 600, 30, 570);
                        //len dung ben trai
                        contentStream.drawLine(580,600, 580, 570);
                        // line ngang 1
                        contentStream.drawLine(30,570 , 580  ,570);
                        contentStream.beginText();
                        contentStream.setFont(PDType1Font.TIMES_BOLD ,  14);
                        contentStream.newLineAtOffset(35, 580);
                        contentStream.showText("Ma SP");
                        contentStream.newLineAtOffset(115, 0);
                        contentStream.showText("Ten SP");
                        contentStream.newLineAtOffset(175, 0);
                        contentStream.showText("So Luong");
                        contentStream.newLineAtOffset(85, 0);
                        contentStream.showText("Don Gia");
                        contentStream.newLineAtOffset(85, 0);
                        contentStream.showText("Thanh Tien");
                        contentStream.endText();
                    }
                    for( ; indexMaSP < maSP.length ; indexMaSP++) {
                        if(y2-distanceRow <= 100) break;
                        y1 = y1 - distanceRow;
                        y2 = y2 - distanceRow;
                        indexRow = indexRow - distanceRow;
                        //line dung ben phai
                        contentStream.drawLine(30, y1, 30, y2);
                        //len dung ben trai
                        contentStream.drawLine(580,y1, 580, y2);
                        // line ngang 1
                        contentStream.drawLine(30,y2 , 580  ,y2);
                        contentStream.beginText();
                        contentStream.setFont(PDType1Font.TIMES_ROMAN ,  14);
                        contentStream.newLineAtOffset(55,indexRow);
                        contentStream.showText(maSP[indexMaSP] + "");
                        contentStream.newLineAtOffset(50, 0);
                        contentStream.showText(tenSP[indexMaSP]);
                        contentStream.newLineAtOffset(240, 0);
                        contentStream.showText(soLuong[indexMaSP] + "");
                        contentStream.newLineAtOffset(65, 0);
                        contentStream.showText(formatNumber(donGia[indexMaSP]) + "");
                        contentStream.newLineAtOffset(85, 0);
                        contentStream.showText(formatNumber(donGia[indexMaSP] * soLuong[indexMaSP]) +  "");
                        contentStream.endText();
                        tongTien = donGia[indexMaSP] * soLuong[indexMaSP] + tongTien;
                    }
                    if(indexMaSP == maSP.length)
                    {
                    	y1 = y1 - distanceRow;
                        y2 = y2 - distanceRow;
                        indexRow = indexRow - distanceRow;
                        //line dung ben phai
                        contentStream.drawLine(30, y1, 30, y2);
                        //len dung ben trai
                        contentStream.drawLine(580,y1, 580, y2);
                        // line ngang 1
                        contentStream.drawLine(30,y2 , 580  ,y2);
                        contentStream.beginText();
                        contentStream.setFont(PDType1Font.TIMES_ROMAN ,  14);
                        contentStream.newLineAtOffset(410,indexRow);
                        contentStream.showText("Tong Tien : " + formatNumber(tongTien));
                        contentStream.endText();
                        break;
                    }
                    
                }
            }
            	File fileToSave = new File("../javasw_fastfood/export/xuatphieu.pdf");
                System.out.println(fileToSave.getPath());
                document.save(fileToSave);
                JOptionPane.showMessageDialog(this, "PDF exported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error exporting PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static String formatNumber(int number) {
        // Sử dụng DecimalFormat để định dạng số với dấu phẩy
        DecimalFormat formatter = new DecimalFormat("#,###");

        // Định dạng số và trả về chuỗi
        return formatter.format(number);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PDFExporter().setVisible(true);
            }
        });
    }
}