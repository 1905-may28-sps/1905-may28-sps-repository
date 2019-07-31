
export interface IAlbum {
  id: number;
  title: string;
  cover: string;
  cover_small: string;
  cover_medium: string;
  cover_big: string;
  cover_xl: string;
  link: string;
  nb_tracks: string;
  label: string;
  duration: number;
  fans: string;
  rating: string;
  release_date: string;
}

export interface IArtist {
  id: number;
  link: string;
  name: string;
  picture: string;
  picture_big: string;
  picture_medium: string;
  picture_small: string;
  picture_xl: string;
  tracklist: string;
  type: string;
}

export interface IResult {
  album: IAlbum;
  artist: IArtist;
  tracks: ITrack;
  duration: number;
  id: number;
  title: string;
}



export interface ITrack {
  id: number;
  title: string;
  link: string;
  duration: number;
  track_position: string;
  preview: string;

}

export class User {
  id: number;
  email: string;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  authorId: number;
  raterId: number;
  constructor() {}
}





