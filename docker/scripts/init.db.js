let idCharacter3dMan = "5f6e321cc997a27a35fa9f62"
let idCharacterABomb = "5f6f9249e36ea57d3a489a46"
let idCharacterIAM = "5f6f92ade36ea57d3a489a47";
let idComicAvengers19 = "5f6e327579cfaea41e0bc559"
let idStory19947 = "5f6f6842c4505159e6bdd6e9"
let idSerie = "5f6f7af23cd82bf3db918f51"
let idEvent = "5f6f80d73cd82bf3db918f52"


let characters_data = [
  {
    "_id": ObjectId(idCharacter3dMan),
    "name": "3-D Man",
    "description": "",
    "modified": new Date(),
    "thumbnail": {
      "path": "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
      "extension": "jpg"
    },
    "resourceURI": "http://marvel.com/character/1011334",
    "urls": [
      {
        "type": "detail",
        "url": "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "wiki",
        "url": "http://marvel.com/universe/3-D_Man_(Chandler)?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "comiclink",
        "url": "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      }
    ],
    "comics": [
      { "$ref": "comics", "$id": ObjectId(idComicAvengers19) }
    ],
    "stories": [
      { "$ref": "stories", "$id": ObjectId(idStory19947) }
    ],
    "series": [
      { "$ref": "series", "$id": ObjectId(idSerie) }
    ],
    "events": [
      { "$ref": "events", "$id": ObjectId(idEvent) }
    ]
  },
  {
    "_id": ObjectId(idCharacterABomb),
    "name": "A-Bomb (HAS)",
    "description": "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
    "modified": new Date(),
    "thumbnail": {
      "path": "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
      "extension": "jpg"
    },
    "resourceURI": "http://gateway.marvel.com/v1/public/characters/1017100",
    "comics": [],
    "series": [],
    "stories": [],
    "events": [],
    "urls": [
      {
        "type": "detail",
        "url": "http://marvel.com/characters/76/a-bomb?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "comiclink",
        "url": "http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      }
    ]
  },
  {
    "id": ObjectId(idCharacterIAM),
    "name": "A.I.M.",
    "description": "AIM is a terrorist organization bent on destroying the world.",
    "modified": new Date(),
    "thumbnail": {
      "path": "http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec",
      "extension": "jpg"
    },
    "resourceURI": "http://gateway.marvel.com/v1/public/characters/1009144",
    "comics": [],
    "series": [],
    "stories": [],
    "events": [],
    "urls": [
      {
        "type": "detail",
        "url": "http://marvel.com/comics/characters/1009144/aim.?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "wiki",
        "url": "http://marvel.com/universe/A.I.M.?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "comiclink",
        "url": "http://marvel.com/comics/characters/1009144/aim.?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      }
    ]
  }
]

let comics_data = [
  {
    "_id": ObjectId(idComicAvengers19),
    "digitalId": 10949,
    "title": "Avengers: The Initiative (2007) #19",
    "issueNumber": 19,
    "variantDescription": "",
    "description": "Join 3-D MAN, CLOUD 9, KOMODO, HARDBALL, and heroes around America in the battle that will decide the fate of the planet and the future of the Initiative program. Will the Kill Krew Army win the day?",
    "modified": new Date(),
    "isbn": "",
    "upc": "5960606084-01911",
    "diamondCode": "SEP082362",
    "ean": "",
    "issn": "",
    "format": "Comic",
    "pageCount": 32,
    "textObjects": [{
        "type": "issue_preview_text",
        "language": "en-us",
        "text": "Join 3-D MAN, CLOUD 9, KOMODO, HARDBALL, and heroes around America in the battle that will decide the fate of the planet and the future of the Initiative program. Will the Kill Krew Army win the day?"
      },
      {
        "type": "issue_solicit_text",
        "language": "en-us",
        "text": "SECRET INVASION Tie-In!\r<br>\"V-S DAY\"\r<br>It's been leading to this since the Hank Pym Skrull first came up with the idea for a Fifty State Initiative.  This is the final assault in the Secret Invasion, a nation-wide plan that will test the limits of 3-D MAN'S superhuman militia, THE KILL KREW ARMY! Join 3-D MAN, CLOUD 9, KOMODO, HARDBALL, and heroes around America in the battle that will decide the fate of the planet and the future of the Initiative program.  Win or lose, there's no turning back.  After today, everything changes.\r<br>Rated T+ ...$2.99\r<br>"
      }
    ],
    "resourceURI": `http://gateway.marvel.com/v1/public/comics/22506`,
    "urls": [{
        "type": "detail",
        "url": "http://marvel.com/comics/issue/22506/avengers_the_initiative_2007_19?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "purchase",
        "url": "http://comicstore.marvel.com/Avengers-The-Initiative-19/digital-comic/10949?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "reader",
        "url": "http://marvel.com/digitalcomics/view.htm?iid=10949&utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "inAppLink",
        "url": "https://applink.marvel.com/issue/10949?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      }
    ],
    "variants": [],
    "collections": [],
    "collectedIssues": [],
    "dates": [{
        "type": "onsaleDate",
        "date": ISODate("2008-12-17T00:00:00-0500")
      },
      {
        "type": "focDate",
        "date": ISODate("2008-11-27T00:00:00-0500")
      },
      {
        "type": "unlimitedDate",
        "date": ISODate("2010-02-23T00:00:00-0500")
      },
      {
        "type": "digitalPurchaseDate",
        "date": ISODate("2011-08-09T00:00:00-0400")
      }
    ],
    "prices": [{
        "type": "printPrice",
        "price": 2.99
      },
      {
        "type": "digitalPurchasePrice",
        "price": 1.99
      }
    ],
    "thumbnail": {
      "path": "http://i.annihil.us/u/prod/marvel/i/mg/d/03/58dd080719806",
      "extension": "jpg"
    },
    "images": [{
      "path": "http://i.annihil.us/u/prod/marvel/i/mg/d/03/58dd080719806",
      "extension": "jpg"
    }],
    "creators": [],
    "characters":  [
      { "$ref": "characters", "$id": ObjectId(idCharacter3dMan) }
    ],
    "stories": [
      { "$ref": "stories", "$id": ObjectId(idStory19947) }
    ],
    "events": [
      { "$ref": "events", "$id": ObjectId(idEvent) }
    ]
  }
]

let stories_data = [
  {
    "_id": ObjectId(idStory19947),
    "title": "Cover #19947",
    "description": "",
    "resourceURI": "http://gateway.marvel.com/v1/public/stories/19947",
    "type": "cover",
    "modified": new Date(),
    "thumbnail": null,
    "creators": [],
    "characters": [
      { "$ref": "characters", "$id": ObjectId(idCharacter3dMan) }
    ],
    "series": [
      { "$ref": "series", "$id": ObjectId(idSerie) }
    ],
    "comics": [
      { "$ref": "comics", "$id": ObjectId(idComicAvengers19) }
    ],
    "events": [
      { "$ref": "events", "$id": ObjectId(idEvent) }
    ],
    "originalIssue": {
      "resourceURI": "http://gateway.marvel.com/v1/public/comics/10223",
      "name": "Marvel Premiere (1972) #35"
    }
  }
]

let series_data = [
  {
    "_id": ObjectId(idSerie),
    "title": "Avengers: The Initiative (2007 - 2010)",
    "description": null,
    "resourceURI": "http://gateway.marvel.com/v1/public/series/1945",
    "urls": [
      {
        "type": "detail",
        "url": "http://marvel.com/comics/series/1945/avengers_the_initiative_2007_-_2010?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      }
    ],
    "startYear": 2007,
    "endYear": 2010,
    "rating": "T",
    "type": "",
    "modified": new Date(),
    "thumbnail": {
      "path": "http://i.annihil.us/u/prod/marvel/i/mg/5/a0/514a2ed3302f5",
      "extension": "jpg"
    },
    "creators": [],
    "characters": [
      { "$ref": "characters", "$id": ObjectId(idCharacter3dMan) }
    ],
    "stories": [
      { "$ref": "stories", "$id": ObjectId(idStory19947) }
    ],
    "comics": [
      { "$ref": "comics", "$id": ObjectId(idComicAvengers19) }
    ],
    "events": [
      { "$ref": "events", "$id": ObjectId(idEvent) }
    ],
    "next": null,
    "previous": null
  }
]

let events_data = [
  {
    "_id": ObjectId(idEvent),
    "title": "Secret Invasion",
    "description": "The shape-shifting Skrulls have been infiltrating the Earth for years, replacing many of Marvel's heroes with impostors, setting the stage for an all-out invasion.",
    "resourceURI": "http://gateway.marvel.com/v1/public/events/269",
    "urls": [
      {
        "type": "detail",
        "url": "http://marvel.com/comics/events/269/secret_invasion?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      },
      {
        "type": "wiki",
        "url": "http://marvel.com/universe/Secret_Invasion?utm_campaign=apiRef&utm_source=4563c471f988ef95d4a3d59e38a3e985"
      }
    ],
    "modified": new Date(),
    "start": ISODate("2008-06-02 00:00:00"),
    "end": ISODate("2009-01-25 00:00:00"),
    "thumbnail": {
      "path": "http://i.annihil.us/u/prod/marvel/i/mg/6/70/51ca1749980ae",
      "extension": "jpg"
    },
    "creators": [],
    "characters": [
      { "$ref": "characters", "$id": ObjectId(idCharacter3dMan) }
    ],
    "stories": [
      { "$ref": "stories", "$id": ObjectId(idStory19947) }
    ],
    "comics": [
      { "$ref": "comics", "$id": ObjectId(idComicAvengers19) }
    ],
    "series": [
      { "$ref": "series", "$id": ObjectId(idSerie) }
    ],
    "next": {
      "resourceURI": "http://gateway.marvel.com/v1/public/events/318",
      "name": "Dark Reign"
    },
    "previous": {
      "resourceURI": "http://gateway.marvel.com/v1/public/events/299",
      "name": "Messiah CompleX"
    }
  }
]

let res = [
  db.characters.insert(characters_data),
  db.comics.insert(comics_data),
  db.stories.insert(stories_data),
  db.series.insert(series_data),
  db.events.insert(events_data)
]

printjson(res)
