let error = true

function getNextSequenceValue(sequenceName){
  var sequenceDocument = db.sequences.findAndModify({
     query:{_id: sequenceName },
     update: {$inc:{value:1}},
     new:true
  })
  return sequenceDocument.value
}

const sequences_data = [
  {
    "_id": "characterid",
    "value": 0
  },
  {
    "_id": "comicid",
    "value": 0
  },
  {
    "_id": "eventid",
    "value": 0
  },
  {
    "_id": "serieid",
    "value": 0
  },
  {
    "_id": "storyid",
    "value": 0
  }
]

db.sequences.insert(sequences_data)

let idCharacter3dMan = getNextSequenceValue("characterid")

let characters_data = [
  {
    "_id": idCharacter3dMan, //1011334
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
    ]
  }
]

let idCommicAvengers19 = getNextSequenceValue("comicid")

let comics_data = [
  {
    "id": idCommicAvengers19,
    "digitalId": 10949,
    "title": "Avengers: The Initiative (2007) #19",
    "issueNumber": 19,
    "variantDescription": "",
    "description": "Join 3-D MAN, CLOUD 9, KOMODO, HARDBALL, and heroes around America in the battle that will decide the fate of the planet and the future of the Initiative program. Will the Kill Krew Army win the day?",
    "modified": "2015-10-27T16:38:23-0400",
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
        "date": "2008-12-17T00:00:00-0500"
      },
      {
        "type": "focDate",
        "date": "2008-11-27T00:00:00-0500"
      },
      {
        "type": "unlimitedDate",
        "date": "2010-02-23T00:00:00-0500"
      },
      {
        "type": "digitalPurchaseDate",
        "date": "2011-08-09T00:00:00-0400"
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
    "characters":  [idCharacter3dMan],
    "stories": [],
    "events": []
  }
]

let res = [
  db.characters.insert(characters_data),
  db.comics.insert(comics_data)
]

printjson(res)

if (error) {
  print('Error, exiting')
  quit(1)
}
