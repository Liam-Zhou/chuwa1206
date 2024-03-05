package com.chuwa.KotlinRedbook.Entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "posts")
data class Post(
                @Column(name = "title", nullable = false)
                var title: String,

                @Column(name = "content", nullable = true)
                var content : String?
        ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @CreationTimestamp
    var createDateTime : LocalDateTime = LocalDateTime.now()
}