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

    private void exportToPDF() {
        String text = textField.getText();
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter text to export!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText(text);
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText(text);
                contentStream.endText();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PDFExporter().setVisible(true);
            }
        });
    }
}