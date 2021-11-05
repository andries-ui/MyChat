package com.example.mychat.Models;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.ArrayList;

public class contactModel {
        public String id;
        public String name;
        public String mobileNumber;
        public Bitmap photo;
        public Uri photoURI;
        private boolean mOnline;

        public contactModel() {
        }

        public contactModel(String id, String name, String mobileNumber, Bitmap photo, Uri photoURI, boolean mOnline) {
                this.id = id;
                this.name = name;
                this.mobileNumber = mobileNumber;
                this.photo = photo;
                this.photoURI = photoURI;
                this.mOnline = mOnline;
        }

        private static int lastContactId = 0;

        public static ArrayList<contactModel> createContactsList(int numContacts) {
                ArrayList<contactModel> contacts = new ArrayList<>();

                for (int i = 1; i <= numContacts; i++) {
                       // contacts.add(new contactModel("Person " + ++lastContactId, i <= numContacts / 2));
                }

                return contacts;
        }


}
