package com.valorantagentsapplicationcleanarchitecture.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgentsResponse(
    @SerializedName("data")
    var `data`: List<Data?>?,
    @SerializedName("status")
    var status: Int? // 200
) : Parcelable {
    @Parcelize
    data class Data(
        @SerializedName("abilities")
        var abilities: List<Ability?>?,
        @SerializedName("assetPath")
        var assetPath: String?, // ShooterGame/Content/Characters/AggroBot/AggroBot_PrimaryAsset
        @SerializedName("background")
        var background: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/background.png
        @SerializedName("backgroundGradientColors")
        var backgroundGradientColors: List<String?>?,
        @SerializedName("bustPortrait")
        var bustPortrait: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/fullportrait.png
        @SerializedName("characterTags")
        var characterTags: List<String?>?,
        @SerializedName("description")
        var description: String?, // Gekko the Angeleno leads a tight-knit crew of calamitous creatures. His buddies bound forward, scattering enemies out of the way, with Gekko chasing them down to regroup and go again.
        @SerializedName("developerName")
        var developerName: String?, // Aggrobot
        @SerializedName("displayIcon")
        var displayIcon: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/displayicon.png
        @SerializedName("displayIconSmall")
        var displayIconSmall: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/displayiconsmall.png
        @SerializedName("displayName")
        var displayName: String?, // Gekko
        @SerializedName("fullPortrait")
        var fullPortrait: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/fullportrait.png
        @SerializedName("fullPortraitV2")
        var fullPortraitV2: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/fullportrait.png
        @SerializedName("isAvailableForTest")
        var isAvailableForTest: Boolean?, // false
        @SerializedName("isBaseContent")
        var isBaseContent: Boolean?, // false
        @SerializedName("isFullPortraitRightFacing")
        var isFullPortraitRightFacing: Boolean?, // false
        @SerializedName("isPlayableCharacter")
        var isPlayableCharacter: Boolean?, // true
        @SerializedName("killfeedPortrait")
        var killfeedPortrait: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/killfeedportrait.png
        @SerializedName("recruitmentData")
        var recruitmentData: RecruitmentData?,
        @SerializedName("role")
        var role: Role?,
        @SerializedName("uuid")
        var uuid: String?, // e370fa57-4757-3604-3648-499e1f642d3f
        @SerializedName("voiceLine")
        var voiceLine: String? // null
    ): Parcelable {
        @Parcelize
        data class Ability(
            @SerializedName("description")
            var description: String?, // EQUIP Wingman. FIRE to send Wingman forward seeking enemies. Wingman unleashes a concussive blast toward the first enemy he sees. ALT FIRE when targeting a Spike site or planted Spike to have Wingman defuse or plant the Spike. To plant, Gekko must have the Spike in his inventory. When Wingman expires he reverts into a dormant globule. INTERACT to reclaim the globule and gain another Wingman charge after a short cooldown.
            @SerializedName("displayIcon")
            var displayIcon: String?, // https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/abilities/ability1/displayicon.png
            @SerializedName("displayName")
            var displayName: String?, // Wingman
            @SerializedName("slot")
            var slot: String? // Ability1
        ): Parcelable

        @Parcelize
        data class RecruitmentData(
            @SerializedName("counterId")
            var counterId: String?, // 7ec37a1e-4526-77dd-1afd-e2ab3b624085
            @SerializedName("endDate")
            var endDate: String?, // 2023-07-25T21:00:00Z
            @SerializedName("levelVpCostOverride")
            var levelVpCostOverride: Int?, // 0
            @SerializedName("milestoneId")
            var milestoneId: String?, // fcca98dc-4a83-2837-9512-f88a0a08fcfd
            @SerializedName("milestoneThreshold")
            var milestoneThreshold: Int?, // 200000
            @SerializedName("startDate")
            var startDate: String?, // 2023-06-27T00:00:00Z
            @SerializedName("useLevelVpCostOverride")
            var useLevelVpCostOverride: Boolean? // false
        ): Parcelable

        @Parcelize
        data class Role(
            @SerializedName("assetPath")
            var assetPath: String?, // ShooterGame/Content/Characters/_Core/Roles/Breaker_PrimaryDataAsset
            @SerializedName("description")
            var description: String?, // Initiators challenge angles by setting up their team to enter contested ground and push defenders away.
            @SerializedName("displayIcon")
            var displayIcon: String?, // https://media.valorant-api.com/agents/roles/1b47567f-8f7b-444b-aae3-b0c634622d10/displayicon.png
            @SerializedName("displayName")
            var displayName: String?, // Initiator
            @SerializedName("uuid")
            var uuid: String? // 1b47567f-8f7b-444b-aae3-b0c634622d10
        ): Parcelable
    }
}