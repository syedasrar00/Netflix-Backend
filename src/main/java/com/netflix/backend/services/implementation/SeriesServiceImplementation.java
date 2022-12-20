package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.SeriesDTO;
import com.netflix.backend.entities.Series;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.AwsS3Repository;
import com.netflix.backend.repositories.SeriesRepository;
import com.netflix.backend.services.SeriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesServiceImplementation implements SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AwsS3Repository awsS3Repository;
    @Override
    public SeriesDTO getSeriesInfo(String seriesId) {
        Series series = seriesRepository.findById(seriesId).orElseThrow(()-> new ResourceNotFoundException("series"));
        String thumbnailLink = awsS3Repository.getPreSignedUrl(series.getThumbnailPath(),60);
        SeriesDTO seriesDTO = mapper.map(series,SeriesDTO.class);
        seriesDTO.setThumbnailLink(thumbnailLink);
        return seriesDTO;
    }
}
