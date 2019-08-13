package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Record;
import edu.mum.cs.cs425.finalproject.senteapp.repository.RecordRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImplementation implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Page<Record> getAllRecordsPage(int pageNo) {
        return recordRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("recordNumber")));
    }

    @Override
    public List<Record> getAllRecordsList() {
        return recordRepository.findAll();
    }

    @Override
    public Record getAllRecordsListByMemberID(Long memberID) {
        return recordRepository.findById(memberID).orElse(null);
    }

    @Override
    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }
}
