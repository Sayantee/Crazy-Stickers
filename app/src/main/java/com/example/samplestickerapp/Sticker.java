/*
 * Copyright (c) WhatsApp Inc. and its affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.example.samplestickerapp;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/*The Bundle object which is used to pass data to Android components is a key/value
store for specialized objects. It is similar to a Map but can only contain these specialized objects
 */

/*Parcelable is an Android only Interface used to serialize a
class so its properties can be transferred from one activity to another.
 */

class Sticker implements Parcelable {
    String imageFileName;
    List<String> emojis;
    long size;

    //General Constructor for
    Sticker(String imageFileName, List<String> emojis) {
        this.imageFileName = imageFileName;
        this.emojis = emojis;
    }

    //Constructor for parcel
    protected Sticker(Parcel in) {
        imageFileName = in.readString();
        emojis = in.createStringArrayList();
        size = in.readLong();
    }
/*Parcelable requires this method to bind everything together. There’s little you need
to do here as the createFromParcel method will return your newly populated object.
 */
    public static final Creator<Sticker> CREATOR = new Creator<Sticker>() {
        @Override
        public Sticker createFromParcel(Parcel in) {
            return new Sticker(in);
        }

        @Override
        public Sticker[] newArray(int size) {
            return new Sticker[size];
        }
    };

    //This method doesn’t do much.
    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //write object values to parcel for storage. Everything is written to
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageFileName);
        dest.writeStringList(emojis);
        dest.writeLong(size);
    }
}
