package com.example.android.animalshelter.view.home.create_shelter.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.edit_text_utils.EtidTextWatcher;
import com.example.android.animalshelter.view.home.create_shelter.CreateShelterEventConsumer;

import androidx.annotation.NonNull;

public class CreateShelterCardView implements ICreateShelterCardView {

    private final View rootView;
    private final EditText shelterTitleEditText;
    private final EditText shelterAddressEditText;
    private final EditText shelterPhoneEditText;
    private final Button saveButton;

    public CreateShelterCardView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                                 final Bundle savedInstanceState,
                                 final CreateShelterEventConsumer consumer) {
        rootView = inflater.inflate(R.layout.fragment_create_shelter_card, container, false);
        shelterTitleEditText = rootView.findViewById(R.id.et_shelter_card_shelter_title);
        shelterAddressEditText = rootView.findViewById(R.id.et_shelter_card_shelter_address);
        shelterPhoneEditText = rootView.findViewById(R.id.et_shelter_card_shelter_phone_number);
        shelterTitleEditText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        shelterAddressEditText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        shelterPhoneEditText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        saveButton = rootView.findViewById(R.id.btn_save_new_shelter_card);
        saveButton.setOnClickListener(v -> consumer.onSaveClick(
                shelterTitleEditText.getText().toString(),
                shelterAddressEditText.getText().toString(),
                shelterPhoneEditText.getText().toString())
        );
    }

    private String getShelterTitle() {
        return shelterTitleEditText.getText().toString();
    }

    private String getShelterAddress() {
        return shelterAddressEditText.getText().toString();
    }

    private String getShelterPhone() {
        return shelterPhoneEditText.getText().toString();
    }

    private void enableButtonIfAllFieldsAreNotEmpty() {
        saveButton.setEnabled(!getShelterTitle().isEmpty() && !getShelterAddress().isEmpty() && !getShelterPhone().isEmpty());
    }

    public View getAndroidView() {
        return rootView;
    }

    @Override
    public void showThatShelterWasCreatedSuccessfully() {
        Toast.makeText(rootView.getContext(), "Saved", Toast.LENGTH_LONG).show();
    }
}
