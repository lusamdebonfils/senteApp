package edu.mum.cs.cs425.finalproject.senteapp.service;

import edu.mum.cs.cs425.finalproject.senteapp.model.Member;
import edu.mum.cs.cs425.finalproject.senteapp.model.Record;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecordService {
    public Page<Record> getAllRecordsPage(int pageNo);
    public List<Record> getAllRecordsList();
    public Record getAllRecordsListByMemberID(Long memberID);
    public Record createRecord(Record record);

    
}
