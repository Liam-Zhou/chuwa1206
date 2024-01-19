# hw7: HW30-DB&REST-APIs-part2.pdf

### GET APIs

API-GET-1
- API: GET https://ghibliapi.herokuapp.com/locations
- RequestBody: N/A, since it is GET
- Response status: 503 Service Unavailable
- Response: Failed to retrieve data: 503

API-GET-2
- API: GET https://pokeapi.co/api/v2/pokemon/ditto
- RequestBody: N/A, since it is GET
- Response status: 200 OK
- Response:
```json
{'abilities': [{'ability': {'name': 'limber', 'url': 'https://pokeapi.co/api/v2/ability/7/'}, 'is_hidden': False, 'slot': 1}, {'ability': {'name': 'imposter', 'url': 'https://pokeapi.co/api/v2/ability/150/'}, 'is_hidden': True, 'slot': 3}], 'base_experience': 101, 'forms': [{'name': 'ditto', 'url': 'https://pokeapi.co/api/v2/pokemon-form/132/'}], 'game_indices': [{'game_index': 76, 'version': {'name': 'red', 'url': 'https://pokeapi.co/api/v2/version/1/'}}, {'game_index': 76, 'version': {'name': 'blue', 'url': 'https://pokeapi.co/api/v2/version/2/'}}, {'game_index': 76, 'version': {'name': 'yellow', 'url': 'https://pokeapi.co/api/v2/version/3/'}}, {'game_index': 132, 'version': {'name': 'gold', 'url': 'https://pokeapi.co/api/v2/version/4/'}}, {'game_index': 132, 'version': {'name': 'silver', 'url': 'https://pokeapi.co/api/v2/version/5/'}}, {'game_index': 132, 'version': {'name': 'crystal', 'url': 'https://pokeapi.co/api/v2/version/6/'}}, {'game_index': 132, 'version': {'name': 'ruby', 'url': 'https://pokeapi.co/api/v2/version/7/'}}, {'game_index': 132, 'version': {'name': 'sapphire', 'url': 'https://pokeapi.co/api/v2/version/8/'}}, {'game_index': 132, 'version': {'name': 'emerald', 'url': 'https://pokeapi.co/api/v2/version/9/'}}, {'game_index': 132, 'version': {'name': 'firered', 'url': 'https://pokeapi.co/api/v2/version/10/'}}, {'game_index': 132, 'version': {'name': 'leafgreen', 'url': 'https://pokeapi.co/api/v2/version/11/'}}, {'game_index': 132, 'version': {'name': 'diamond', 'url': 'https://pokeapi.co/api/v2/version/12/'}}, {'game_index': 132, 'version': {'name': 'pearl', 'url': 'https://pokeapi.co/api/v2/version/13/'}}, {'game_index': 132, 'version': {'name': 'platinum', 'url': 'https://pokeapi.co/api/v2/version/14/'}}, {'game_index': 132, 'version': {'name': 'heartgold', 'url': 'https://pokeapi.co/api/v2/version/15/'}}, {'game_index': 132, 'version': {'name': 'soulsilver', 'url': 'https://pokeapi.co/api/v2/version/16/'}}, {'game_index': 132, 'version': {'name': 'black', 'url': 'https://pokeapi.co/api/v2/version/17/'}}, {'game_index': 132, 'version': {'name': 'white', 'url': 'https://pokeapi.co/api/v2/version/18/'}}, {'game_index': 132, 'version': {'name': 'black-2', 'url': 'https://pokeapi.co/api/v2/version/21/'}}, {'game_index': 132, 'version': {'name': 'white-2', 'url': 'https://pokeapi.co/api/v2/version/22/'}}], 'height': 3, 'held_items': [{'item': {'name': 'metal-powder', 'url': 'https://pokeapi.co/api/v2/item/234/'}, 'version_details': [{'rarity': 5, 'version': {'name': 'ruby', 'url': 'https://pokeapi.co/api/v2/version/7/'}}, {'rarity': 5, 'version': {'name': 'sapphire', 'url': 'https://pokeapi.co/api/v2/version/8/'}}, {'rarity': 5, 'version': {'name': 'emerald', 'url': 'https://pokeapi.co/api/v2/version/9/'}}, {'rarity': 5, 'version': {'name': 'firered', 'url': 'https://pokeapi.co/api/v2/version/10/'}}, {'rarity': 5, 'version': {'name': 'leafgreen', 'url': 'https://pokeapi.co/api/v2/version/11/'}}, {'rarity': 5, 'version': {'name': 'diamond', 'url': 'https://pokeapi.co/api/v2/version/12/'}}, {'rarity': 5, 'version': {'name': 'pearl', 'url': 'https://pokeapi.co/api/v2/version/13/'}}, {'rarity': 5, 'version': {'name': 'platinum', 'url': 'https://pokeapi.co/api/v2/version/14/'}}, {'rarity': 5, 'version': {'name': 'heartgold', 'url': 'https://pokeapi.co/api/v2/version/15/'}}, {'rarity': 5, 'version': {'name': 'soulsilver', 'url': 'https://pokeapi.co/api/v2/version/16/'}}, {'rarity': 5, 'version': {'name': 'black', 'url': 'https://pokeapi.co/api/v2/version/17/'}}, {'rarity': 5, 'version': {'name': 'white', 'url': 'https://pokeapi.co/api/v2/version/18/'}}, {'rarity': 5, 'version': {'name': 'black-2', 'url': 'https://pokeapi.co/api/v2/version/21/'}}, {'rarity': 5, 'version': {'name': 'white-2', 'url': 'https://pokeapi.co/api/v2/version/22/'}}, {'rarity': 5, 'version': {'name': 'x', 'url': 'https://pokeapi.co/api/v2/version/23/'}}, {'rarity': 5, 'version': {'name': 'y', 'url': 'https://pokeapi.co/api/v2/version/24/'}}, {'rarity': 5, 'version': {'name': 'omega-ruby', 'url': 'https://pokeapi.co/api/v2/version/25/'}}, {'rarity': 5, 'version': {'name': 'alpha-sapphire', 'url': 'https://pokeapi.co/api/v2/version/26/'}}, {'rarity': 5, 'version': {'name': 'sun', 'url': 'https://pokeapi.co/api/v2/version/27/'}}, {'rarity': 5, 'version': {'name': 'moon', 'url': 'https://pokeapi.co/api/v2/version/28/'}}, {'rarity': 5, 'version': {'name': 'ultra-sun', 'url': 'https://pokeapi.co/api/v2/version/29/'}}, {'rarity': 5, 'version': {'name': 'ultra-moon', 'url': 'https://pokeapi.co/api/v2/version/30/'}}]}, {'item': {'name': 'quick-powder', 'url': 'https://pokeapi.co/api/v2/item/251/'}, 'version_details': [{'rarity': 50, 'version': {'name': 'diamond', 'url': 'https://pokeapi.co/api/v2/version/12/'}}, {'rarity': 50, 'version': {'name': 'pearl', 'url': 'https://pokeapi.co/api/v2/version/13/'}}, {'rarity': 50, 'version': {'name': 'platinum', 'url': 'https://pokeapi.co/api/v2/version/14/'}}, {'rarity': 50, 'version': {'name': 'heartgold', 'url': 'https://pokeapi.co/api/v2/version/15/'}}, {'rarity': 50, 'version': {'name': 'soulsilver', 'url': 'https://pokeapi.co/api/v2/version/16/'}}, {'rarity': 50, 'version': {'name': 'black', 'url': 'https://pokeapi.co/api/v2/version/17/'}}, {'rarity': 50, 'version': {'name': 'white', 'url': 'https://pokeapi.co/api/v2/version/18/'}}, {'rarity': 50, 'version': {'name': 'black-2', 'url': 'https://pokeapi.co/api/v2/version/21/'}}, {'rarity': 50, 'version': {'name': 'white-2', 'url': 'https://pokeapi.co/api/v2/version/22/'}}, {'rarity': 50, 'version': {'name': 'x', 'url': 'https://pokeapi.co/api/v2/version/23/'}}, {'rarity': 50, 'version': {'name': 'y', 'url': 'https://pokeapi.co/api/v2/version/24/'}}, {'rarity': 50, 'version': {'name': 'omega-ruby', 'url': 'https://pokeapi.co/api/v2/version/25/'}}, {'rarity': 50, 'version': {'name': 'alpha-sapphire', 'url': 'https://pokeapi.co/api/v2/version/26/'}}, {'rarity': 50, 'version': {'name': 'sun', 'url': 'https://pokeapi.co/api/v2/version/27/'}}, {'rarity': 50, 'version': {'name': 'moon', 'url': 'https://pokeapi.co/api/v2/version/28/'}}, {'rarity': 50, 'version': {'name': 'ultra-sun', 'url': 'https://pokeapi.co/api/v2/version/29/'}}, {'rarity': 50, 'version': {'name': 'ultra-moon', 'url': 'https://pokeapi.co/api/v2/version/30/'}}]}], 'id': 132, 'is_default': True, 'location_area_encounters': 'https://pokeapi.co/api/v2/pokemon/132/encounters', 'moves': [{'move': {'name': 'transform', 'url': 'https://pokeapi.co/api/v2/move/144/'}, 'version_group_details': [{'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'red-blue', 'url': 'https://pokeapi.co/api/v2/version-group/1/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'yellow', 'url': 'https://pokeapi.co/api/v2/version-group/2/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'gold-silver', 'url': 'https://pokeapi.co/api/v2/version-group/3/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'crystal', 'url': 'https://pokeapi.co/api/v2/version-group/4/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'ruby-sapphire', 'url': 'https://pokeapi.co/api/v2/version-group/5/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'emerald', 'url': 'https://pokeapi.co/api/v2/version-group/6/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'firered-leafgreen', 'url': 'https://pokeapi.co/api/v2/version-group/7/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'diamond-pearl', 'url': 'https://pokeapi.co/api/v2/version-group/8/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'platinum', 'url': 'https://pokeapi.co/api/v2/version-group/9/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'heartgold-soulsilver', 'url': 'https://pokeapi.co/api/v2/version-group/10/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'black-white', 'url': 'https://pokeapi.co/api/v2/version-group/11/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'colosseum', 'url': 'https://pokeapi.co/api/v2/version-group/12/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'xd', 'url': 'https://pokeapi.co/api/v2/version-group/13/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'black-2-white-2', 'url': 'https://pokeapi.co/api/v2/version-group/14/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'x-y', 'url': 'https://pokeapi.co/api/v2/version-group/15/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'omega-ruby-alpha-sapphire', 'url': 'https://pokeapi.co/api/v2/version-group/16/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'sun-moon', 'url': 'https://pokeapi.co/api/v2/version-group/17/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'ultra-sun-ultra-moon', 'url': 'https://pokeapi.co/api/v2/version-group/18/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'lets-go-pikachu-lets-go-eevee', 'url': 'https://pokeapi.co/api/v2/version-group/19/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'sword-shield', 'url': 'https://pokeapi.co/api/v2/version-group/20/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'brilliant-diamond-and-shining-pearl', 'url': 'https://pokeapi.co/api/v2/version-group/23/'}}, {'level_learned_at': 1, 'move_learn_method': {'name': 'level-up', 'url': 'https://pokeapi.co/api/v2/move-learn-method/1/'}, 'version_group': {'name': 'scarlet-violet', 'url': 'https://pokeapi.co/api/v2/version-group/25/'}}]}], 'name': 'ditto', 'order': 214, 'past_abilities': [], 'past_types': [], 'species': {'name': 'ditto', 'url': 'https://pokeapi.co/api/v2/pokemon-species/132/'}, 'sprites': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/132.png', 'back_female': None, 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/132.png', 'back_shiny_female': None, 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png', 'front_shiny_female': None, 'other': {'dream_world': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/132.svg', 'front_female': None}, 'home': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/shiny/132.png', 'front_shiny_female': None}, 'official-artwork': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/132.png', 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/132.png'}, 'showdown': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/back/132.gif', 'back_female': None, 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/back/shiny/132.gif', 'back_shiny_female': None, 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/132.gif', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/shiny/132.gif', 'front_shiny_female': None}}, 'versions': {'generation-i': {'red-blue': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/back/132.png', 'back_gray': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/back/gray/132.png', 'back_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/transparent/back/132.png', 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/132.png', 'front_gray': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/gray/132.png', 'front_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/red-blue/transparent/132.png'}, 'yellow': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/back/132.png', 'back_gray': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/back/gray/132.png', 'back_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/transparent/back/132.png', 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/132.png', 'front_gray': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/gray/132.png', 'front_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-i/yellow/transparent/132.png'}}, 'generation-ii': {'crystal': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/132.png', 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/back/shiny/132.png', 'back_shiny_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/shiny/132.png', 'back_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/back/132.png', 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/132.png', 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/shiny/132.png', 'front_shiny_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/shiny/132.png', 'front_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/crystal/transparent/132.png'}, 'gold': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/back/132.png', 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/back/shiny/132.png', 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/132.png', 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/shiny/132.png', 'front_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/gold/transparent/132.png'}, 'silver': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/back/132.png', 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/back/shiny/132.png', 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/132.png', 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/shiny/132.png', 'front_transparent': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-ii/silver/transparent/132.png'}}, 'generation-iii': {'emerald': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/emerald/132.png', 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/emerald/shiny/132.png'}, 'firered-leafgreen': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/back/132.png', 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/back/shiny/132.png', 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/132.png', 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/shiny/132.png'}, 'ruby-sapphire': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/back/132.png', 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/back/shiny/132.png', 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/132.png', 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/ruby-sapphire/shiny/132.png'}}, 'generation-iv': {'diamond-pearl': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/back/132.png', 'back_female': None, 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/back/shiny/132.png', 'back_shiny_female': None, 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/diamond-pearl/shiny/132.png', 'front_shiny_female': None}, 'heartgold-soulsilver': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/back/132.png', 'back_female': None, 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/back/shiny/132.png', 'back_shiny_female': None, 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/heartgold-soulsilver/shiny/132.png', 'front_shiny_female': None}, 'platinum': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/132.png', 'back_female': None, 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/back/shiny/132.png', 'back_shiny_female': None, 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iv/platinum/shiny/132.png', 'front_shiny_female': None}}, 'generation-v': {'black-white': {'animated': {'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/132.gif', 'back_female': None, 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/back/shiny/132.gif', 'back_shiny_female': None, 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/132.gif', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/animated/shiny/132.gif', 'front_shiny_female': None}, 'back_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/132.png', 'back_female': None, 'back_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/back/shiny/132.png', 'back_shiny_female': None, 'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-v/black-white/shiny/132.png', 'front_shiny_female': None}}, 'generation-vi': {'omegaruby-alphasapphire': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/omegaruby-alphasapphire/shiny/132.png', 'front_shiny_female': None}, 'x-y': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vi/x-y/shiny/132.png', 'front_shiny_female': None}}, 'generation-vii': {'icons': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/icons/132.png', 'front_female': None}, 'ultra-sun-ultra-moon': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/ultra-sun-ultra-moon/132.png', 'front_female': None, 'front_shiny': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/ultra-sun-ultra-moon/shiny/132.png', 'front_shiny_female': None}}, 'generation-viii': {'icons': {'front_default': 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-viii/icons/132.png', 'front_female': None}}}}, 'stats': [{'base_stat': 48, 'effort': 1, 'stat': {'name': 'hp', 'url': 'https://pokeapi.co/api/v2/stat/1/'}}, {'base_stat': 48, 'effort': 0, 'stat': {'name': 'attack', 'url': 'https://pokeapi.co/api/v2/stat/2/'}}, {'base_stat': 48, 'effort': 0, 'stat': {'name': 'defense', 'url': 'https://pokeapi.co/api/v2/stat/3/'}}, {'base_stat': 48, 'effort': 0, 'stat': {'name': 'special-attack', 'url': 'https://pokeapi.co/api/v2/stat/4/'}}, {'base_stat': 48, 'effort': 0, 'stat': {'name': 'special-defense', 'url': 'https://pokeapi.co/api/v2/stat/5/'}}, {'base_stat': 48, 'effort': 0, 'stat': {'name': 'speed', 'url': 'https://pokeapi.co/api/v2/stat/6/'}}], 'types': [{'slot': 1, 'type': {'name': 'normal', 'url': 'https://pokeapi.co/api/v2/type/1/'}}], 'weight': 40}
```

API-GET-3
- API: GET https://www.boredapi.com/api/activity
- RequestBody: N/A, since it is GET
- Response status: 200 OK
- Response:
```json
{
  'activity': 'Study a foreign language',
  'type': 'education',
  'participants': 1,
  'price': 0,
  'link': '',
  'key': '9765530',
  'accessibility': 0.1
}
```

API-GET-4
- API: GET https://dog.ceo/api/breeds/image/random
- RequestBody: N/A, since it is GET
- Response status: 200 OK
- Response:
```json
{
  'message': 'https://images.dog.ceo/breeds/vizsla/n02100583_6740.jpg',
  'status': 'success'
}
```

API-GET-5
- API: GET https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd
- RequestBody: N/A, since it is GET
- Response status: 200 OK
- Response:
```json
{
  'bitcoin': {'usd': 41146}
}
```

### POST APIs

API-POST-1
- API: POST https://jsonplaceholder.typicode.com/posts
- RequestBody: 
```json
{
  "title": "foo",
  "body": "bar",
  "userId": 1
}
```
- Response status: 201 Created
- Response:
```json
{
  'title': 'foo',
  'body': 'bar',
  'userId': 1,
  'id': 101
}
```

API-POST-2
- API: POST https://jsonplaceholder.typicode.com/posts
- RequestBody: 
```json
{
  "name": "morpheus",
  "job": "leader"
}
```
- Response status: 201 Created
- Response:
```json
{
  'name': 'morpheus',
  'job': 'leader',
  'id': '703',
  'createdAt': '2024-01-19T05:57:01.304Z'
}
```

API-POST-3
- API: POST https://httpbin.org/post
- RequestBody: 
```json
{
  "name": "John Doe",
  "age": 30
}
```
- Response status: 200 OK
- Response:
```json
{
  'args': {},
  'data': '{"name": "John Doe", "age": 30}',
  'files': {},
  'form': {},
  'headers': {
    'Accept': '*/*',
    'Accept-Encoding': 'gzip, deflate',
    'Content-Length': '31',
    'Content-Type': 'application/json',
    'Host': 'httpbin.org',
    'User-Agent': 'python-requests/2.31.0',
    'X-Amzn-Trace-Id': 'Root=1-65aa0f70-5a45e95d694e1bdc6f616e6c'
  }, 
  'json': {'age': 30, 'name': 'John Doe'}, 
  'origin': '104.48.81.129', 
  'url': 'https://httpbin.org/post'
}
```

API-POST-4
- API: POST https://postman-echo.com/post
- RequestBody: 
```json
{
  "key1": "value1",
  "key2": "value2"
}
```
- Response status: 200 OK
- Response:
```json
{
  'args': {},
  'data': {'key1': 'value1', 'key2': 'value2'},
  'files': {},
  'form': {},
  'headers': {'x-forwarded-proto': 'https', 'x-forwarded-port': '443', 'host': 'postman-echo.com', 'x-amzn-trace-id': 'Root=1-65aa0fab-447866652eb393b25f71ec26', 'content-length': '36', 'user-agent': 'python-requests/2.31.0', 'accept-encoding': 'gzip, deflate', 'accept': '*/*', 'content-type': 'application/json'},
  'json': {'key1': 'value1', 'key2': 'value2'},
  'url': 'https://postman-echo.com/post'
}
```

API-POST-5
- API: POST https://webhook.site/12345678-1234-1234-1234-123456789012
- RequestBody: 
```json
{
  "sample": "data",
  "test": true
}
```
- Response status: 404 Not Found
- Response:
```json
{
  'success': False,
  'error': {'message': 'Token not found', 'id': None}
}
```

### PUT APIs

API-PUT-1
- API: PUT https://jsonplaceholder.typicode.com/posts/1
- RequestBody: 
```json
{
  "id": 1,
  "title": "updated title",
  "body": "updated body",
  "userId": 1
}
```
- Response status: 200 OK 
- Response:
```json
{
  'id': 1,
  'title': 'updated title',
  'body': 'updated body',
  'userId': 1
}
```

API-PUT-2
- API: PUT https://reqres.in/api/users/2
- RequestBody: 
```json
{
  "name": "morpheus",
  "job": "zion resident"
}
```
- Response status: 200 OK 
- Response:
```json
{
  'name': 'morpheus',
  'job': 'zion resident',
  'updatedAt': '2024-01-19T06:11:06.721Z'
}
```

API-PUT-3
- API: PUT https://httpbin.org/put
- RequestBody: 
```json
{
  "name": "Jane Doe",
  "age": 25
}
```
- Response status: 200 OK 
- Response:
```json
{
  'args': {},
  'data': '{"name": "Jane Doe", "age": 25}',
  'files': {},
  'form': {},
  'headers': {
    'Accept': '*/*',
    'Accept-Encoding': 'gzip, deflate',
    'Content-Length': '31',
    'Content-Type': 'application/json',
    'Host': 'httpbin.org',
    'User-Agent': 'python-requests/2.31.0',
    'X-Amzn-Trace-Id': 'Root=1-65aa12b3-34d2c60d253c0a6350dfe7c3'
  },
  'json': {'age': 25, 'name': 'Jane Doe'},
  'origin': '104.48.81.129',
  'url': 'https://httpbin.org/put'
}
```

### DELETE APIs

API-DELETE-1
- API: DELETE https://jsonplaceholder.typicode.com/posts/1
- Request Body: N/A, since it is DELETE
- Response status: 200 OK 
- Response:
```json
{}
```

API-DELETE-2
- API: DELETE https://reqres.in/api/users/2
- Request Body: N/A, since it is DELETE
- Response status: 204 No Content 
- Response:
```json
{}
```

