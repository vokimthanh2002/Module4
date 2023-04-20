package com.example.quanlythucung.bean;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
public class UserPDFExporter {
    private List<DichVu> dichVus;

    public UserPDFExporter(List<DichVu> dichVus) {
        this.dichVus = dichVus;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID dich vu", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Ten dich vu", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Loai dich vu", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mo ta", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Gia", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (DichVu dichVu : dichVus) {
            table.addCell(String.valueOf(dichVu.getIdDichVu()));
            table.addCell(dichVu.getLoaiDichVu());
            table.addCell(String.valueOf(dichVu.getTenDichVu()));
            table.addCell(dichVu.getMoTa());
            table.addCell(String.valueOf(dichVu.getChiPhi()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Danh sach dich vu", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
