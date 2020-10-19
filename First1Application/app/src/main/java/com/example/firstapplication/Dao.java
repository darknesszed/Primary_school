package com.example.firstapplication;

import android.os.Parcel;
import android.os.Parcelable;

//  通过Android的方式序列化
public class Dao implements Parcelable
{

   private int age;
   private String name;


   @Override
   public int describeContents() { return 0; }

   @Override
   public void writeToParcel(Parcel dest, int flags)
   {
       dest.writeInt(this.age);
       dest.writeString(this.name);
   }

   public Dao() {}

   protected Dao(Parcel in)
   {
       this.age = in.readInt();
       this.name = in.readString();
   }

   public static final Creator<Dao> CREATOR = new Creator<Dao>()
   {
       @Override
       public Dao createFromParcel(Parcel source) {return new Dao(source);}

       @Override
       public Dao[] newArray(int size) {return new Dao[size];}
   };
}
