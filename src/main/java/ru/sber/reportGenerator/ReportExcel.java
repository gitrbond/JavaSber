package ru.sber.reportGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ReportExcel implements Report{
    public final String[][] stringArray;

    public ReportExcel(String[][] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public byte[] asBytes() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ExporterToExcelFormat.ExportStringArrayToExcelFormat(stringArray).write(bos);
        //return stringArray.toByteArray();
        return bos.toByteArray();
        /*DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(i);
        dos.flush();
        return bos.toByteArray();*/
    }

    @Override
    public void writeTo(OutputStream os) throws IOException {
        os.write(asBytes());
    }

    public String[][] getStringArray() {
        return stringArray;
    }

    public void renameFields(String[] strs) {
        System.arraycopy(strs, 0, stringArray[0], 0, strs.length);
    }
}
