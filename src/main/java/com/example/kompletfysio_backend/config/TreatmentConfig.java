package com.example.kompletfysio_backend.config;

import com.example.kompletfysio_backend.model.DurationEntity;
import com.example.kompletfysio_backend.model.TreatmentEntity;
import com.example.kompletfysio_backend.repository.DurationRepository;
import com.example.kompletfysio_backend.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TreatmentConfig implements CommandLineRunner {

    @Autowired
    TreatmentRepository treatmentRepository;

    @Autowired
    DurationRepository durationRepository;

    @Override
    public void run(String... args) throws Exception {
        initTreatment();
    }

    public void initTreatment(){
        DurationEntity duration90 = new DurationEntity();
        duration90.setDurationMinutes(90);
        durationRepository.save(duration90);

        DurationEntity duration60 = new DurationEntity();
        duration60.setDurationMinutes(60);
        durationRepository.save(duration60);

        DurationEntity duration45 = new DurationEntity();
        duration45.setDurationMinutes(45);
        durationRepository.save(duration45);

        DurationEntity duration30 = new DurationEntity();
        duration30.setDurationMinutes(30);
        durationRepository.save(duration30);

        TreatmentEntity treatmentMassage30 = new TreatmentEntity();
        treatmentMassage30.setTreatmentName("Massage [30 min]");
        treatmentMassage30.setPrice(310);
        treatmentMassage30.setDuration(duration30);
        treatmentRepository.save(treatmentMassage30);

        TreatmentEntity treatmentGravidbehandling = new TreatmentEntity();
        treatmentGravidbehandling.setTreatmentName("Gravidbehandling [60 min]");
        treatmentGravidbehandling.setPrice(620);
        treatmentGravidbehandling.setDuration(duration60);
        treatmentRepository.save(treatmentGravidbehandling);

        TreatmentEntity treatmentElbowFixFirst = new TreatmentEntity();
        treatmentElbowFixFirst.setTreatmentName("TEMP");
        treatmentElbowFixFirst.setPrice(650);
        treatmentElbowFixFirst.setDuration(duration60);
        treatmentRepository.save(treatmentElbowFixFirst);


    }
}