package com.example.demo.Service;

import com.example.demo.DTO.HistoryDTO;
import com.example.demo.Entity.History;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.HistoryRepository;
import com.example.demo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository, UsersRepository usersRepository) {
        this.historyRepository = historyRepository;
        this.usersRepository = usersRepository;
    }

    private HistoryDTO toHistoryDTO(History history) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setId(history.getId());
        historyDTO.setUserId(history.getUser().getId());
        historyDTO.setBloodSugerHistory(history.getBloodSugerHistory());
        historyDTO.setSession(history.getSession());
        historyDTO.setCheckDate(history.getCheckDate());
        historyDTO.setDiseaseLevel(history.getDiseaseLevel());

        return historyDTO;
    }


    public HistoryDTO addHistory(HistoryDTO historyDTO) {
        Optional<Users> user = usersRepository.findById(historyDTO.getUserId());
        if(user.isEmpty()) {
            return null;
        }


        History history = new History();
        history.setUser(user.get());
        history.setBloodSugerHistory(historyDTO.getBloodSugerHistory());
        history.setSession(historyDTO.getSession());
        history.setCheckDate(historyDTO.getCheckDate());
        history.setDiseaseLevel(historyDTO.getDiseaseLevel());

        History savedHistory = historyRepository.save(history);
        return toHistoryDTO(savedHistory);
    }

    @Transactional(readOnly = true)
    public List<HistoryDTO> getAllHistoryByUserId(int id) {
        List<History> historyList = historyRepository.findAllByUserId(id);
        if(historyList.isEmpty()) {
            return null;
        } else {
            List<HistoryDTO> resultList = new ArrayList<>();
            for (History history : historyList) {
                resultList.add(toHistoryDTO(history));
            }
            return resultList;
        }
    }

    public HistoryDTO getHistoryById(int id) {
        Optional<History> history = historyRepository.findById(id);
        if(history.isPresent()) {
            return toHistoryDTO(history.get());
        } else {
            return null;
        }
    }


    public boolean deleteHistoryById(int id) {
        if (!historyRepository.existsById(id)) {
            return false;
        } else {
            historyRepository.deleteById(id);
            return true;
        }
    }

    @Transactional
    public boolean deleteHistoryByUserId(int userId) {
        Optional<Users> user = usersRepository.findById(userId);
        if(user.isPresent()) {
            historyRepository.deleteAllByUserId(userId);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateHistory(HistoryDTO historyDTO) {
        Optional<History> history = historyRepository.findById(historyDTO.getId());
        Optional<Users> user = usersRepository.findById(historyDTO.getUserId());
        if(history.isEmpty() || user.isEmpty()) {
            return false;
        }
        history.get().setSession(historyDTO.getSession());
        history.get().setCheckDate(historyDTO.getCheckDate());
        history.get().setUser(user.get());
        history.get().setBloodSugerHistory(historyDTO.getBloodSugerHistory());
        history.get().setDiseaseLevel(historyDTO.getDiseaseLevel());
        historyRepository.save(history.get());
        return true;
    }



}
