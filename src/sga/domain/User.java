/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sga.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author giacomo
 */
public class User {

    private static User _instance;
    private String _outputDir;
    private String _outputFile;

    public static User getInstance()
    {
        if(null == _instance)
            _instance = new User();
        return _instance;
    }
    private User()
    {
        _repository = new PatientRepository();
        _outputDir = System.getProperty("fileconn.dir.photos") + "sga/";
        _outputFile = _outputDir + "all.txt";
    }

    private PatientRepository _repository;
    public PatientRepository getRepository()
    {
        return _repository;
    }

    private Patient _selectedPatient;
    public void setSelectedPatient(Patient patient)
    {
        _selectedPatient = patient;
    }

    public Patient getSelectedPatient()
    {
        return _selectedPatient;
    }

    public void save()
    {
        try {
            JSONArray object = User.getInstance().getRepository().toJSON();
            String serialization = object.toString();
            /*
            FileConnection d = (FileConnection) Connector.open(_outputDir, Connector.READ_WRITE);

            if (!d.exists()) {
                d.mkdir();
            }

            FileConnection c = (FileConnection) Connector.open(_outputFile, Connector.READ_WRITE);

            if(c.exists())
            {
                //Date now = new Date();
                //c.rename("all." + String.valueOf(now.getTime())+".txt");
                c.delete();
                c = (FileConnection) Connector.open(_outputFile, Connector.READ_WRITE);
            }

            c.create();
            */
            FileConnection c = (FileConnection) Connector.open(_outputFile, Connector.READ_WRITE);

            OutputStream out = c.openOutputStream();

            out.write(serialization.getBytes());
            out.flush();
            out.close();

            c.close();
/*
            c = (FileConnection) Connector.open(outputFile, Connector.READ_WRITE);
            //
            InputStream in = c.openInputStream();
            byte[] b = new byte[50];
            in.read(b);
            System.out.println(new String(b, 0, b.length));
 *
 */
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }

    public void load()
    {
        try {
            FileConnection fileConn = (FileConnection) Connector.open(_outputFile, Connector.READ_WRITE);
            if(fileConn.exists())
            {
                InputStream fis = fileConn.openInputStream();
                long overallSize = fileConn.fileSize();
                int length = 0;
                byte[] filedata = new byte[0];
                while (length < overallSize) {//converting the selected file to bytes
                    byte[] data = new byte[256];
                    int readAmount = fis.read(data, 0, 256);
                    byte[] newFileData = new byte[filedata.length + 256];
                    System.arraycopy(filedata, 0, newFileData, 0, length);
                    System.arraycopy(data, 0, newFileData, length, readAmount);
                    filedata = newFileData;
                    length += readAmount;
                }
                fis.close();
                fileConn.close();

                JSONArray obj = new JSONArray(new String(filedata, 0, filedata.length));
                //System.out.println();
                _repository.fromJSON(obj);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }
}
