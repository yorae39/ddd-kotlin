package com.example.dddkotlin.product.application.mediadata

import com.example.dddkotlin.product.domain.CommandListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MediaDataService() {

    @Autowired
    private lateinit var mediaDataRegistry: MediaDataRegistry

    @CommandListener
    fun handle(command: RegisterForMediaDataUpdatesCommand) {
        mediaDataRegistry.handle(command)
    }
}