package Custom;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PDFExport {
	public static String formatNumber(int number) {
        // Sử dụng DecimalFormat để định dạng số với dấu phẩy
        DecimalFormat formatter = new DecimalFormat("#,###");

        // Định dạng số và trả về chuỗi
        return formatter.format(number);
    }	
	
	
	
	public String exportToPDF(int[] maNL , String[] tenNL , int[] soLuongNL , int[] donGiaNL , String currentDate,String nhaCungCap,String tenNhanVien) {
		int[] maSP = Arrays.copyOf(maNL, maNL.length);
    	String[] tenSP = Arrays.copyOf(tenNL, tenNL.length);
    	int[] soLuong = Arrays.copyOf(soLuongNL, soLuongNL.length);
    	int[] donGia = Arrays.copyOf(donGiaNL, donGiaNL.length);
        try {
        	PDDocument document = new PDDocument();
        	PDFont font = PDType0Font.load(document, new File("../javasw_fastfood/Unicode/UVNVietSach_R.TTF"));
        	PDFont fontB = PDType0Font.load(document, new File("../javasw_fastfood/Unicode/UVNVietSach_B.TTF"));
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
                        contentStream.setFont(fontB, 16);
                        contentStream.newLineAtOffset(230, 700);
                        contentStream.showText("CHI TIẾT PHIẾU NHẬP");
                        contentStream.setFont(font, 14);
                        contentStream.newLineAtOffset(-130, -20);
                        contentStream.showText("Nhân viên : " + tenNhanVien);
                        contentStream.newLineAtOffset(0, -20);
                        contentStream.showText("Ngày lập : " + currentDate);
                        contentStream.newLineAtOffset(0, -20);
                        contentStream.showText("Nhà cung cấp :" + nhaCungCap);
                        contentStream.newLineAtOffset(50, -20);
                        contentStream.showText("==============================");
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
                        contentStream.setFont(fontB ,  14);
                        contentStream.newLineAtOffset(35, 580);
                        contentStream.showText("Mã SP");
                        contentStream.newLineAtOffset(115, 0);
                        contentStream.showText("Tên SP");
                        contentStream.newLineAtOffset(175, 0);
                        contentStream.showText("Số Lượng");
                        contentStream.newLineAtOffset(85, 0);
                        contentStream.showText("Đơn giá");
                        contentStream.newLineAtOffset(85, 0);
                        contentStream.showText("Thành Tiền");
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
                        contentStream.setFont(font ,  14);
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
                        contentStream.setFont(font ,  14);
                        contentStream.newLineAtOffset(410,indexRow);
                        contentStream.showText("Tổng Tiền : " + formatNumber(tongTien) + "VNĐ");
                        contentStream.endText();
                        break;
                    }
                    
                }
            }
            	File fileToSave = new File("../javasw_fastfood/export/xuatphieu.pdf");
                System.out.println(fileToSave.getPath());
                document.save(fileToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Xuất phiếu nhập thành công";
    }
}
