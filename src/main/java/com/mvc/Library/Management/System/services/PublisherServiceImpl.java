package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Publisher;
import com.mvc.Library.Management.System.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{
    @Autowired
    PublisherRepository publisherRepository;
    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId).get();
    }

    @Override
    public List<Publisher> publishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher updatePublisher(Publisher publisher, Integer publisherId) {
        publisher.setId(publisherId);
        return publisherRepository.save(publisher);
    }

    @Override
    public Void deletePublisher(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
        return null;
    }
}
