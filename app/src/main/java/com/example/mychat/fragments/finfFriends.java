package com.example.mychat.fragments;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mychat.Models.ContactDTO;
import com.example.mychat.Models.contactModel;
import com.example.mychat.R;
import com.example.mychat.contentResolver.contactResolver;
import com.example.mychat.listAdapters.contactListAdapter;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

public class finfFriends extends DialogFragment {

    View view;
    ImageView back;
    ListView rvContacts;
    contactListAdapter adapter;
    List<contactModel> contactlist;
    contactResolver contactResolver;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.find_friends_layout, container, false);
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Init();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return view;
    }

    private void Init(){
        back = view.findViewById(R.id.btnback);
        rvContacts = view.findViewById(R.id.myfriends);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Initialize contacts
        //contactlist = new List<contactModel>();
//        try {
//            contactlist = contactResolver.getContacts(getContext());
//            // Create adapter passing in the sample user data
//            adapter = new contactListAdapter(getContext(), contactlist);
//            // Attach the adapter to the recyclerview to populate items
//            rvContacts.setAdapter(adapter);
//            // Set layout manager to position the items
//            rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));
//        }catch (Exception e){
//            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//        }
    }

    //    public void getContacts() {
//
//        // create cursor and query the data
//        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
//        startManagingCursor(cursor);
//
//        // data is a array of String type which is
//        // used to store Number ,Names and id.
//        String[] data = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone._ID};
//        int[] to = {android.R.id.text1, android.R.id.text2};
//
//        // creation of adapter using SimpleCursorAdapter class
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getContext(), android.R.layout.simple_list_item_2, cursor, data, to);
//
//        // Calling setAdaptor() method to set created adapter
//        rvContacts.setAdapter(adapter);
//        rvContacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//    }


    /* Return all contacts and show each contact data in android monitor console as debug info. */
//    private List<ContactDTO> getAllContacts()
//    {
//        List<ContactDTO> ret = new ArrayList<ContactDTO>();
//        // Get all raw contacts id list.
//        List<Integer> rawContactsIdList = getContext().getRawContactsIdList();
//        int contactListSize = rawContactsIdList.size();
//        ContentResolver contentResolver = getContext().getContentResolver();
//        // Loop in the raw contacts list.
//        for(int i=0;i<contactListSize;i++)
//        {
//            // Get the raw contact id.
//            Integer rawContactId = rawContactsIdList.get(i);
//            Log.d(TAG_ANDROID_CONTACTS, "raw contact id : " + rawContactId.intValue());
//            // Data content uri (access data table. )
//            Uri dataContentUri = ContactsContract.Data.CONTENT_URI;
//            // Build query columns name array.
//            List<String> queryColumnList = new ArrayList<String>();
//            // ContactsContract.Data.CONTACT_ID = "contact_id";
//            queryColumnList.add(ContactsContract.Data.CONTACT_ID);
//            // ContactsContract.Data.MIMETYPE = "mimetype";
//            queryColumnList.add(ContactsContract.Data.MIMETYPE);
//            queryColumnList.add(ContactsContract.Data.DATA1);
//            queryColumnList.add(ContactsContract.Data.DATA2);
//            queryColumnList.add(ContactsContract.Data.DATA3);
//            queryColumnList.add(ContactsContract.Data.DATA4);
//            queryColumnList.add(ContactsContract.Data.DATA5);
//            queryColumnList.add(ContactsContract.Data.DATA6);
//            queryColumnList.add(ContactsContract.Data.DATA7);
//            queryColumnList.add(ContactsContract.Data.DATA8);
//            queryColumnList.add(ContactsContract.Data.DATA9);
//            queryColumnList.add(ContactsContract.Data.DATA10);
//            queryColumnList.add(ContactsContract.Data.DATA11);
//            queryColumnList.add(ContactsContract.Data.DATA12);
//            queryColumnList.add(ContactsContract.Data.DATA13);
//            queryColumnList.add(ContactsContract.Data.DATA14);
//            queryColumnList.add(ContactsContract.Data.DATA15);
//            // Translate column name list to array.
//            String queryColumnArr[] = queryColumnList.toArray(new String[queryColumnList.size()]);
//            // Build query condition string. Query rows by contact id.
//            StringBuffer whereClauseBuf = new StringBuffer();
//            whereClauseBuf.append(ContactsContract.Data.RAW_CONTACT_ID);
//            whereClauseBuf.append("=");
//            whereClauseBuf.append(rawContactId);
//            // Query data table and return related contact data.
//            Cursor cursor = contentResolver.query(dataContentUri, queryColumnArr, whereClauseBuf.toString(), null, null);
//            /* If this cursor return database table row data.
//               If do not check cursor.getCount() then it will throw error
//               android.database.CursorIndexOutOfBoundsException: Index 0 requested, with a size of 0.
//               */
//            if(cursor!=null && cursor.getCount() > 0)
//            {
//                StringBuffer lineBuf = new StringBuffer();
//                cursor.moveToFirst();
//                lineBuf.append("Raw Contact Id : ");
//                lineBuf.append(rawContactId);
//                long contactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID));
//                lineBuf.append(" , Contact Id : ");
//                lineBuf.append(contactId);
//                do{
//                    // First get mimetype column value.
//                    String mimeType = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
//                    lineBuf.append(" \r\n , MimeType : ");
//                    lineBuf.append(mimeType);
//                    List<String> dataValueList = getColumnValueByMimetype(cursor, mimeType);
//                    int dataValueListSize = dataValueList.size();
//                    for(int j=0;j < dataValueListSize;j++)
//                    {
//                        String dataValue = dataValueList.get(j);
//                        lineBuf.append(" , ");
//                        lineBuf.append(dataValue);
//                    }
//                }while(cursor.moveToNext());
//                Log.d(TAG_ANDROID_CONTACTS, lineBuf.toString());
//            }
//            Log.d(TAG_ANDROID_CONTACTS, "=========================================================================");
//        }
//        return ret;
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        int length = grantResults.length;
//        if(length > 0)
//        {
//            int grantResult = grantResults[0];
//            if(grantResult == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(getContext(), "You allowed permission, please click the button again.", Toast.LENGTH_LONG).show();
//            }else
//            {
//                Toast.makeText(getContext(), "You denied permission.", Toast.LENGTH_LONG).show();
//            }
//        }
}
