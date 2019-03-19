
package com.example.acronymapp.model.datasource.acronym;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Acronym implements Parcelable
{

    @SerializedName("sf")
    @Expose
    private String sf;
    @SerializedName("lfs")
    @Expose
    private List<Lf> lfs = null;
    public final static Creator<Acronym> CREATOR = new Creator<Acronym>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Acronym createFromParcel(Parcel in) {
            return new Acronym(in);
        }

        public Acronym[] newArray(int size) {
            return (new Acronym[size]);
        }

    }
    ;

    protected Acronym(Parcel in) {
        this.sf = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.lfs, (com.example.acronymapp.model.datasource.acronym.Lf.class.getClassLoader()));
    }

    public Acronym() {
    }

    public String getSf() {
        return sf;
    }

    public void setSf(String sf) {
        this.sf = sf;
    }

    public List<Lf> getLfs() {
        return lfs;
    }

    public void setLfs(List<Lf> lfs) {
        this.lfs = lfs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sf);
        dest.writeList(lfs);
    }

    public int describeContents() {
        return  0;
    }

}
