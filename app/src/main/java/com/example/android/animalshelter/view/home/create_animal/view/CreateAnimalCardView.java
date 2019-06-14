package com.example.android.animalshelter.view.home.create_animal.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.edit_text_utils.EtidTextWatcher;
import com.example.android.animalshelter.view.home.create_animal.CreateAnimalEventConsumer;

public class CreateAnimalCardView implements ICreateAnimalCardView {

    private final View rootView;
    private final EditText etKindEditText;
    private final EditText etNameEditText;
    private final EditText etAgeText;
    private final Spinner sSex;
    private final Spinner sWalkPeriod;
    private final Button btnSave;

    private int genderAnimal = 0;
    private int walkPeriod = 1;


    public CreateAnimalCardView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, final CreateAnimalEventConsumer consumer) {
        rootView = inflater.inflate(R.layout.fragment_create_animal_card, container, false);
        etKindEditText = rootView.findViewById(R.id.et_animal_card_animal_kind);
        etNameEditText = rootView.findViewById(R.id.et_animal_card_animal_name);
        etAgeText = rootView.findViewById(R.id.et_animal_card_animal_age);
        sSex = rootView.findViewById(R.id.spinner_animal_card_sex);
        sWalkPeriod = rootView.findViewById(R.id.spinner_animal_card_period);
        btnSave = rootView.findViewById(R.id.btn_save_new_animal_card);
        btnSave.setOnClickListener(v -> consumer.onSaveClick(
                etKindEditText.getText().toString(),
                etNameEditText.getText().toString(),
                Integer.parseInt(etAgeText.getText().toString()),
                genderAnimal,
                walkPeriod)
        );
        etKindEditText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        etNameEditText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        etAgeText.addTextChangedListener(new EtidTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                enableButtonIfAllFieldsAreNotEmpty();
            }
        });
        setupSexSpinner();
        setupWalkPeriodSpinner();
    }

    private void setupSexSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(rootView.getContext(),
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        sSex.setAdapter(genderSpinnerAdapter);
        sSex.setSelection(0);

        sSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(rootView.getResources().getString(R.string.gender_female))) {
                        genderAnimal = 0;
                    } else if (selection.equals(rootView.getResources().getString(R.string.gender_male))) {
                        genderAnimal = 1;
                    } else {
                        genderAnimal = 2;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                genderAnimal = 0;
            }
        });
    }

    private void setupWalkPeriodSpinner() {
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(rootView.getContext(),
                R.array.array_period_options, android.R.layout.simple_spinner_item);

        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        sWalkPeriod.setAdapter(genderSpinnerAdapter);
        sWalkPeriod.setSelection(0);

        sWalkPeriod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(rootView.getResources().getString(R.string.period_1))) {
                        walkPeriod = 1;
                    } else if (selection.equals(rootView.getResources().getString(R.string.period_2))) {
                        walkPeriod = 2;
                    } else {
                        walkPeriod = 3;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                genderAnimal = 1;
            }
        });
    }

    private String getAnimalKind() {
        return etKindEditText.getText().toString();
    }

    private String getAnimalName() {
        return etNameEditText.getText().toString();
    }

    private String getAnimalAge() {
        return etAgeText.getText().toString();
    }

    private void enableButtonIfAllFieldsAreNotEmpty() {
        btnSave.setEnabled(!getAnimalKind().isEmpty() && !getAnimalName().isEmpty() && !getAnimalAge().isEmpty());
    }

    @Override
    public View getAndroidView() {
        return rootView;
    }

    @Override
    public void showThatAnimalWasCreatedSuccessfully() {
        Toast.makeText(rootView.getContext(), "Saved", Toast.LENGTH_LONG).show();
    }
}
