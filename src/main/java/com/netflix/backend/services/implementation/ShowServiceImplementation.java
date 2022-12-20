package com.netflix.backend.services.implementation;

import com.netflix.backend.DTO.ShowDTO;
import com.netflix.backend.entities.Show;
import com.netflix.backend.exceptions.ResourceNotFoundException;
import com.netflix.backend.repositories.AwsS3Repository;
import com.netflix.backend.repositories.ShowRepository;
import com.netflix.backend.services.ShowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImplementation implements ShowService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private AwsS3Repository awsS3Repository;
    @Override
    public ShowDTO getShowInfo(String showId) {
        Show show = showRepository.findById(showId).orElseThrow(()-> new ResourceNotFoundException("show"));
        ShowDTO showDTO = mapper.map(show,ShowDTO.class);
        String thumbnailLink = awsS3Repository.getPreSignedUrl(show.getThumbnailPath(),60);
        showDTO.setThumbnailLink(thumbnailLink);
        return showDTO;
    }

    @Override
    public List<ShowDTO> getShowByName(String name) {
        return showRepository.findByShowName(name).stream().map((e)-> {
            ShowDTO showDTO = mapper.map(e,ShowDTO.class);
            String thumbnailLink = awsS3Repository.getPreSignedUrl(e.getThumbnailPath(),60);
            showDTO.setThumbnailLink(thumbnailLink);
            return showDTO;
        }).collect(Collectors.toList());
    }
}
