let quote = ["Tigers can grow up to a length of 11 feet and weigh up to 300 kilograms when fully developed.", 
  "Tigers belong to the cat family and are the biggest of their species.",
  "Tigers are excellent swimmers and capable of swimming up to six kilometres at a stretch.",
  "Tigers are lone hunters and generally hunt at night, taking advantage of the dark and their strong night vision.",
  "Tigers can reach a maximum speed of 65 km/ h while chasing a meal for the family.",
  "Similarly, tigers can jump over 5 metres during hunts.",
  "The average life of a dog depending on the breed can vary from 10 to 14 years.",
  "Due to their amazing sense of smell, dogs are capable of differentiating and recognising odours. For this reason, they are used to sniff out drugs and weapons by anti-terrorist squads and police departments all over the world.",
"As per the available scientific evidence, dogs are known to have been domesticated about 15000 years ago.",
"Domesticated dogs are omnivores, as they can eat grains, vegetables, and meat as a part of their diet.",
"Dogs are incredibly emotional and actually get jealous when they see their master getting friendly with another human or animal.",
"The most common type of dolphins found is Bottlenose dolphins.",
"Dolphins have a blowhole located at the top of their heads which they use to breathe.",
"A group of dolphins is known as a pod or a school which consists of a dozen of these intelligent animals.",
"The elephant uses its trunk to know the size, shape, and temperature of objects. It is used to suck in water or pick up food and put it into its mouth.",
"An adult elephant needs to drink more than 200 litres of water every day and it uses its tusks to dig the earth for this purpose.",
"The huge, thin ears of an elephant are made of blood vessels which help them to regulate their body temperature.",
"A full-grown male giraffe can weigh up to 1400 kilograms",
"The length of a giraffe’s neck measures between 1.5 to 1.8 metres.",
"A giraffe’s tail is made up of hair that is about 10 times thicker than human hair.",
"Countries like Singapore, Ethiopia, England, Bulgaria, the Netherlands, and Albania have named the lion as their national animal.",
"Lions have a lifespan of about 12 years.",
"The breeding of lion and tigers gives birth to off-spring known as ligers and tigons.",
"Lions are the most sociable animals in the cat family and live in prides of up to 25 individuals.",
"Sharks have a set of smaller teeth behind the front teeth. The smaller teeth move forward and the front teeth then fall off.",
"Sharks have to keep moving to get oxygen into their bloodstream, as the water passes over the gills.",
"Great whites can cut through the water at a speed of 30 km/ h and are the deadliest of all.",
"Scientists use a wax plug in the whale’s ear that has a pattern on it to determine its age.",
"Most whales do not have teeth and use a comb-like fibre to filter tiny creatures from the water.",
"Whale groups either consist of only male or only female whales and both almost never mix.",
"Camels are a good source of milk, wool, and meat and are used for transportation or carrying heavy loads, too.",
"Camels have a thick coat on their body, provides protection from extreme heat and cold, making them suitable for deserts.",
"Camels can survive up to six months without water or food due to the fatty tissues stored in their humps.",
"Cheetahs have great eyesight and are able to sight their prey from five kilometres away during the daytime.",
"Cheetahs are the only members of the cat family unable to roar. However, they can purr quite loudly, especially when they are in a group or during one of their grooming sessions.",
"As opposed to other cat family members like lions and leopards who hunt at night, cheetahs are able to hunt only during the day."
]
let btn = document.getElementById('btn');
let output = document.getElementById('output');

btn.addEventListener('click', function(){
  var randomQuote = quote[Math.floor(Math.random() * quote.length)]
  output.innerHTML = randomQuote;
})