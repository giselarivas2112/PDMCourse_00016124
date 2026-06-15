package com.example.app_pdm.AppRankeUca.data.repositories

import com.pdmcourse2026.basictemplate.data.api.KtorClient
import com.pdmcourse2026.basictemplate.data.api.rankeuca.OptionResponseDto
import com.pdmcourse2026.basictemplate.data.api.rankeuca.VoteRequestDto
import com.pdmcourse2026.basictemplate.data.api.rankeuca.VoteResponseDto
import com.pdmcourse2026.basictemplate.data.api.rankeuca.toModel
import com.pdmcourse2026.basictemplate.model.Option
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class VoteApiRepository : VoteRepository {

    override suspend fun getOptions(): Result<List<Option>> {
        try {
            val response: List<OptionResponseDto> = KtorClient.client.get("https://qjcxdvfzyseuvezacxsd.supabase.co/functions/v1/rankeuca/options").body()


            return Result.success(
                response.map { optionDto -> optionDto.toModel()
                }
            )

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun vote(optionId: Int): Result<String> {
        try {
            val request = VoteRequestDto(
                optionId = optionId
            )

            val response: VoteResponseDto = KtorClient.client.post("https://qjcxdvfzyseuvezacxsd.supabase.co/functions/v1/rankeuca/vote") {
                setBody(request)
            }.body()

            return Result.success(response.message)

        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}