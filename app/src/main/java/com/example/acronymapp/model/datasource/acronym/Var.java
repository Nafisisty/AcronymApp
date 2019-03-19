
package com.example.acronymapp.model.datasource.acronym;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Var implements Parcelable
{

    @SerializedName("lf")
    @Expose
    private String lf;
    @SerializedName("freq")
    @Expose
    private String freq;
    @SerializedName("since")
    @Expose
    private String since;
    public final static Creator<Var> CREATOR = new Creator<Var>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Var createFromParcel(Parcel in) {
            return new Var(in);
        }

        public Var[] newArray(int size) {
            return (new Var[size]);
        }

    }
    ;

    protected Var(Parcel in) {
        this.lf = ((String) in.readValue((String.class.getClassLoader())));
        this.freq = ((String) in.readValue((String.class.getClassLoader())));
        this.since = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Var() {
    }

    public String getLf() {
        return lf;
    }

    public void setLf(String lf) {
        this.lf = lf;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lf);
        dest.writeValue(freq);
        dest.writeValue(since);
    }

    public int describeContents() {
        return  0;
    }

}
