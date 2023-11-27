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
        initDurationAndTreatment();
    }

    public void initDurationAndTreatment() {
        //INIT durations
        DurationEntity duration90 = initDurationEntity(90);
        DurationEntity duration60 = initDurationEntity(60);
        DurationEntity duration45 = initDurationEntity(45);
        DurationEntity duration30 = initDurationEntity(30);

        //INIT massage treatments
        TreatmentEntity treatmentMassage30 = initTreatmentEntity("Massage", 310, duration30);
        TreatmentEntity treatmentMassage45 = initTreatmentEntity("Massage", 465, duration45);
        TreatmentEntity treatmentMassage60 = initTreatmentEntity("Massage", 620, duration60);
        TreatmentEntity treatmentMassage90 = initTreatmentEntity("Massage", 930, duration90);

        //INIT Fysio- & sportsfysioterapi treatments
        TreatmentEntity sportsfysioterapiFirst60 = initTreatmentEntity("sportsfysioterapiFirst", 650, duration60);
        TreatmentEntity sportsfysioterapi60 = initTreatmentEntity("sportsfysioterapi", 620, duration60);
        TreatmentEntity sportsfysioterapi45 = initTreatmentEntity("sportsfysioterapi", 465, duration45);
        TreatmentEntity sportsfysioterapi30 = initTreatmentEntity("sportsfysioterapi", 310, duration30);
        TreatmentEntity sportsfysioterapiEar30 = initTreatmentEntity("sportsfysioterapiEar", 75, duration30);

        //INIT Gravid & efterfødsel treatments
        TreatmentEntity Gravidbehandling60 = initTreatmentEntity("Gravidbehandling", 620, duration60);
        TreatmentEntity Gravidbehandling30 = initTreatmentEntity("Gravidbehandling", 310, duration30);

        //INIT Lungefysioterapi treatments
        TreatmentEntity Lunge60 = initTreatmentEntity("lunge", 650, duration60);
        TreatmentEntity Lunge30 = initTreatmentEntity("lunge", 465, duration45);
    }

    private DurationEntity initDurationEntity(int minutes) {
        DurationEntity duration = new DurationEntity();
        duration.setDurationMinutes(minutes);
        durationRepository.save(duration);
        return duration;
    }

    private TreatmentEntity initTreatmentEntity(String treatmentName, int price, DurationEntity duration) {
        TreatmentEntity treatment = new TreatmentEntity();
        treatment.setTreatmentName(treatmentName);
        treatment.setPrice(price);
        treatment.setDuration(duration);
        treatmentRepository.save(treatment);
        return treatment;
    }
}
