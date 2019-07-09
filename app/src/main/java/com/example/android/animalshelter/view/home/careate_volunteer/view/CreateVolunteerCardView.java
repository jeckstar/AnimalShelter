package com.example.android.animalshelter.view.home.careate_volunteer.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.edit_text_utils.EtidTextWatcher;
import com.example.android.animalshelter.view.home.careate_volunteer.CreateVolunteerEventConsumer;

import androidx.annotation.NonNull;

public class CreateVolunteerCardView implements ICreateVolunteerCardView {

    private final View rootView;
    private final EditText volunteerFirstNameEditText;
    private final EditText volunteerLastNameEditText;
    private final Button saveButton;
    private final TextView tvVolunteers;

    public CreateVolunteerCardView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                                 final Bundle savedInstanceState,
                                 final CreateVolunteerEventConsumer consumer) {
        rootView = inflater.inflate(R.layout.fragment_create_volunteer_card, container, false);
        volunteerFirstNameEditText = rootView.findViewById(R.id.et_volunteer_card_first_name);
        volunteerLastNameEditText = rootView.findViewById(R.id.et_volunteer_card_last_name);
        volunteerFirstNameEditText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        volunteerLastNameEditText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        saveButton = rootView.findViewById(R.id.btn_save_new_volunteer_card);
        saveButton.setOnClickListener(v -> consumer.onSaveClick(
                volunteerFirstNameEditText.getText().toString(),
                volunteerLastNameEditText.getText().toString())
        );
        tvVolunteers = rootView.findViewById(R.id.tv_volunteer_list);
    }

    private String getShelterTitle() {
        return volunteerFirstNameEditText.getText().toString();
    }

    private String getShelterAddress() {
        return volunteerLastNameEditText.getText().toString();
    }

    private void enableButtonIfAllFieldsAreNotEmpty() {
        saveButton.setEnabled(!getShelterTitle().isEmpty() && !getShelterAddress().isEmpty());
    }

    public View getAndroidView() {
        return rootView;
    }

    @Override
    public void showVolunteers(String name) {
        tvVolunteers.setText(name);
    }

    @Override
    public void showThatVolunteerWasCreatedSuccessfully() {
        Toast.makeText(rootView.getContext(), "Saved", Toast.LENGTH_LONG).show();
    }
}
