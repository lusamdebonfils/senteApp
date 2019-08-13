package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.Address;
import edu.mum.cs.cs425.finalproject.senteapp.repository.AddressRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImplementation implements AddressService {

    private AddressRepository addressRepository;
    public AddressServiceImplementation(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}
