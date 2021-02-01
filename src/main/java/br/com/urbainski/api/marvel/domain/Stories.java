package br.com.urbainski.api.marvel.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
@Entity
@Table(name = "STORIES")
public class Stories extends AbstractDomain<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TYPE")
    private StoriesType type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CHARACTERS", referencedColumnName = "ID")
    private Characters characters;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

}