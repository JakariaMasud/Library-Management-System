package com.mvc.Library.Management.System.services;

import com.mvc.Library.Management.System.entities.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher addPublisher(Publisher publisher);
    Publisher getPublisherById(Integer publisherId);
    List<Publisher> publishers();
    Publisher updatePublisher(Publisher publisher,Integer publisherId);
    Void deletePublisher(Integer publisherId);
}
